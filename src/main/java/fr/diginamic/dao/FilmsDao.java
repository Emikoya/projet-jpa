package fr.diginamic.dao;

import fr.diginamic.entities.Films;

import javax.persistence.EntityManager;

public class FilmsDao implements InterfaceDao<Films>{

    private EntityManager em;

    public FilmsDao(EntityManager em) {
        this.em = em;
    }

    @Override
    public void insert(Films films) {
        em.persist(films);
    }
}
