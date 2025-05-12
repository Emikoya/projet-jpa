package fr.diginamic.dao;

import fr.diginamic.entities.Lieux;
import fr.diginamic.entities.Pays;

import javax.persistence.*;
import java.sql.SQLException;

public class LieuxDao implements InterfaceDao<Lieux>{
    private EntityManager entityManager;

    public LieuxDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Lieux extraire(Lieux lieux) throws SQLException {
        return null;
    }

    @Override
    public void insert(Lieux lieux) {
        entityManager.persist(lieux);
    }

    /**
     * Récupère un lieu existant par son nom, ou le crée s'il n'existe pas encore.
     */
    public Lieux getOrCreate(int id, String etat, String ville, Pays pays) {
        Lieux lieux = entityManager.find(Lieux.class, id);
        if (lieux == null) {
            lieux = new Lieux();
            lieux.setEtat(etat);
            lieux.setVille(ville);
            lieux.setPays(pays);
            insert(lieux);
        }
        return lieux;
    }

}
