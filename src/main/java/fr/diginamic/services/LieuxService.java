package fr.diginamic.services;

import fr.diginamic.dao.LieuxDao;
import fr.diginamic.entities.Lieux;
import fr.diginamic.entities.Pays;

import javax.persistence.EntityManager;

public class LieuxService {

    /**
     * Cette méthode permet d'instancier une transaction avec la base de données
     * en vérifiant l'existence du lieux avec la méthode getOrCreate
     */
    public static Lieux getLieux(EntityManager entityManager, Integer id, String etat, String ville, Pays pays) {
        Lieux lieux;

        try {
            LieuxDao dao = new LieuxDao(entityManager);
            lieux = dao.getOrCreate(id, etat, ville, pays);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return lieux;
    }
}
