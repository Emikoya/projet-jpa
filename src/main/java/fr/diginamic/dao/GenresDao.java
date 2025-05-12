package fr.diginamic.dao;

import fr.diginamic.entities.Genres;

import javax.persistence.EntityManager;

public class GenresDao implements InterfaceDao<Genres> {

    private EntityManager entityManager;

    public GenresDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void insert(Genres genres) {
        entityManager.persist(genres);
    }
}
