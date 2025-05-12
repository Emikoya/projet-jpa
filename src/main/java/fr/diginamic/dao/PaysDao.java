package fr.diginamic.dao;

import fr.diginamic.entities.Pays;

import javax.persistence.EntityManager;

public class PaysDao implements InterfaceDao<Pays>{

    private EntityManager entityManager;

    public PaysDao(EntityManager em) {
        this.entityManager = em;
    }

    @Override
    public void insert(Pays pays) {
        entityManager.persist(pays);
    }
}
