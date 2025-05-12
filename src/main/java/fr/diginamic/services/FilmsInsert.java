package fr.diginamic.services;

import fr.diginamic.dao.FilmsDao;
import fr.diginamic.dto.FilmsDto;
import fr.diginamic.entities.Films;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.util.List;

public class FilmsInsert {
    public void insertData() throws IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_project");
        EntityManager em = emf.createEntityManager();

        ConvertFilmsDto reader = new ConvertFilmsDto();
        List<FilmsDto> dtos = reader.mapperJson("src/main/resources/filmstest.json");

        FilmsDao dao = new FilmsDao(em);

        try {
            em.getTransaction().begin();

            for (FilmsDto dto : dtos) {
                Films film = ConvertFilmsDto.toEntity(dto);
                dao.insert(film);
            }

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException(e);
        } finally {
            em.close();
            emf.close();
        }
    }
}
