package org.example;

import fr.diginamic.services.DatabaseVerif;
import fr.diginamic.services.inserts.FilmsInsertService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception {

        // Vérification de l'existence de la base de donnée
        DatabaseVerif service = new DatabaseVerif();
        service.databaseVerif();

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa_project");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            FilmsInsertService insertFilms = new FilmsInsertService();
            insertFilms.insertData(entityManager);


//        PaysService insertPays = new PaysService();
//        insertPays.insertData(entityManager);

//        GenresInsert insertGenres = new GenresInsert();
//        insertGenres.insertData(entityManager);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw new RuntimeException(e);
        }finally {
            entityManager.close();
        }

    }
}