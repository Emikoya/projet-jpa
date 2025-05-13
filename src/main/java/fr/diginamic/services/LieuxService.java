package fr.diginamic.services;

import fr.diginamic.dao.LieuxDao;
import fr.diginamic.dao.PaysDao;
import fr.diginamic.entities.Lieux;
import fr.diginamic.entities.Pays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class LieuxService {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_project");

    /**
     * Cette méthode permet de récupérer un pays existant ou d'en créer un nouveau
     * si celui-ci n'existe pas encore.
     */
    public Lieux getLieux(int id, String etat, String ville, Pays pays) {
        EntityManager em = emf.createEntityManager();
        Lieux lieux;

        try {
            em.getTransaction().begin();

            LieuxDao dao = new LieuxDao(em);
            lieux = dao.getOrCreate(id, etat, ville, pays);

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException(e);
        } finally {
            em.close();
        }

        return lieux;
    }
}
