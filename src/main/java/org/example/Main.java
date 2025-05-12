package org.example;

import fr.diginamic.services.DatabaseVerif;
import fr.diginamic.services.inserts.FilmsInsertService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) throws Exception {

        // Vérification de l'existence de la base de donnée
        DatabaseVerif service = new DatabaseVerif();
        service.databaseVerif();

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa_project");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        FilmsInsertService insertFilms = new FilmsInsertService();
        insertFilms.insertData(entityManager);

//        PaysInsertService insertPays = new PaysInsertService();
//        insertPays.insertData(entityManager);

//        GenresInsert insertGenres = new GenresInsert();
//        insertGenres.insertData(entityManager);

    }
}