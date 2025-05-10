package org.example;

import fr.diginamic.services.DatabaseVerif;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Main {
    public static void main(String[] args) throws Exception {

        // Vérification de l'existence de la base de donnée
        DatabaseVerif service = new DatabaseVerif();
        service.databaseVerif();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_project");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}