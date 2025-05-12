package fr.diginamic.services.inserts;

import fr.diginamic.dao.GenresDao;
import fr.diginamic.entities.Genres;
import fr.diginamic.entities.enums.GenresType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Cette classe permet d'instancier une transaction avec la base de données
 * afin d'insérer les données de la classe enum GenresTypes.
 */

public class GenresInsertService {

    public void insertData(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa_project");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        GenresDao genresDao = new GenresDao(entityManager);

        try {
            EntityTransaction tx = entityManager.getTransaction();
            tx.begin();
            for (GenresType type : GenresType.values()) {
                    Genres genre = new Genres();
                    genre.setNom(type);
                    genresDao.insert(genre);
            }
            tx.commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException(e);
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }


}
