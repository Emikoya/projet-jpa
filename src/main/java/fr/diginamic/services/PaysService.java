package fr.diginamic.services;

import fr.diginamic.dao.PaysDao;
import fr.diginamic.entities.Pays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Service chargé de la gestion de Pays.
 */
public class PaysService {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_project");

    /**
     * Cette méthode permet de récupérer un pays existant ou d'en créer un nouveau
     * si celui-ci n'existe pas encore.
     */
    public Pays getPays(String nomPays, String url) {
        EntityManager em = emf.createEntityManager();
        Pays pays;

        try {
            em.getTransaction().begin();

            PaysDao dao = new PaysDao(em);
            pays = dao.getOrCreate(nomPays, url);

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
