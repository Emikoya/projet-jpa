package fr.diginamic.services;

import fr.diginamic.dao.PaysDao;
import fr.diginamic.entities.Pays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PaysService {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_project");

    public Pays getOrCreate(String nomPays) {
        EntityManager em = emf.createEntityManager();
        Pays pays;

        try {
            em.getTransaction().begin();

            PaysDao dao = new PaysDao(em);
            pays = dao.getOrCreate(nomPays);

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException(e);
        } finally {
            em.close();
        }

        return pays;
    }
}
