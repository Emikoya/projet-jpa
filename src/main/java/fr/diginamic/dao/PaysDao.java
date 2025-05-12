package fr.diginamic.dao;

import fr.diginamic.entities.Pays;

import javax.persistence.*;
import java.sql.SQLException;
import java.util.List;

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

    public Pays getOrCreate(String nomPays) {
        try {
            return entityManager.find(Pays.class, nomPays);
        } catch (Exception e) {
            return create(nomPays);
        }
    }

    private Pays create(String nomPays) {
        Pays pays = new Pays(nomPays);
        entityManager.persist(pays);
        return pays;
    }

}
