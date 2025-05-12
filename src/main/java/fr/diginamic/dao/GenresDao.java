package fr.diginamic.dao;

import fr.diginamic.entities.Genres;

import javax.persistence.EntityManager;
import java.sql.SQLException;
import java.util.List;

public class GenresDao implements InterfaceDao<Genres> {

    private EntityManager entityManager;

    public GenresDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Genres extraire(Genres genres) throws SQLException {
        return null;
    }

    @Override
    public void insert(Genres genres) {
        entityManager.persist(genres);
    }
}
