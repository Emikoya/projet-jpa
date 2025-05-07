package org.example;

import fr.diginamic.dao.FilmsDao;
import fr.diginamic.dto.FilmsDto;
import fr.diginamic.entities.Films;
import fr.diginamic.services.ConvertFilmsDto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ma-persistence-unit");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        ConvertFilmsDto reader = new ConvertFilmsDto();
        List<FilmsDto> dtos = reader.mapperJson("src/main/resources/filmstest.json");

        FilmsDao dao = new FilmsDao(em);

        for (FilmsDto dto : dtos) {
            Films film = ConvertFilmsDto.toEntity(dto);
            dao.insert(film);
        }

        em.getTransaction().commit();
        em.close();
        emf.close();

    }
}