package fr.diginamic.dao;

import fr.diginamic.entities.Pays;

import javax.persistence.*;
import java.sql.SQLException;

/**
 * DAO pour accéder aux entités Pays en base de données.
 * Fournit des opérations de recherche, insertion & mise à jour.
 */
public class PaysDao implements InterfaceDao<Pays>{

    private EntityManager entityManager;

    public PaysDao(EntityManager em) {
        this.entityManager = em;
    }

    @Override
    public Pays extraire(Pays pays) throws SQLException {
        return null;
    }

    @Override
    public void insert(Pays pays) {
        entityManager.persist(pays);
    }

    /**
     * Récupère un pays existant par son nom, ou le crée s'il n'existe pas encore.
     */
    public Pays getOrCreate(String nomPays, String url) {
        Pays pays = entityManager.find(Pays.class, nomPays);
        if (pays == null) {
            pays = new Pays();
            pays.setNom(nomPays);
            pays.setUrl(url);
            insert(pays);
        }
        return pays;
    }


}
