package fr.diginamic.services.inserts;

import fr.diginamic.dao.FilmsDao;
import fr.diginamic.dto.FilmsDto;
import fr.diginamic.entities.Films;
import fr.diginamic.services.converts.FilmsFileConverter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.util.List;

/**
 * Cette classe permet d'instancier une transaction avec la base de données
 * afin d'insérer les données d'un film d'un fichier json.
 */

public class FilmsInsertService {
    public void insertData() throws IOException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa_project");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        FilmsFileConverter reader = new FilmsFileConverter();
        List<FilmsDto> dtos = reader.mapperJson("src/main/resources/filmstest.json");

        FilmsDao dao = new FilmsDao(entityManager);

        try {
            entityManager.getTransaction().begin();

            for (FilmsDto dto : dtos) {
                Films film = FilmsFileConverter.toEntity(dto);
                dao.insert(film);
            }

            entityManager.getTransaction().commit();

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException(e);
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
