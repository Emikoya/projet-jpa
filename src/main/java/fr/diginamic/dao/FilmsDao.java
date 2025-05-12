package fr.diginamic.dao;

import fr.diginamic.entities.Films;
import fr.diginamic.entities.Pays;

import javax.persistence.EntityManager;
import java.sql.SQLException;
import java.util.List;

public class FilmsDao implements InterfaceDao<Films>{

    private EntityManager em;

    public FilmsDao(EntityManager em) {
        this.em = em;
    }

    @Override
    public Films extraire(Films films) throws SQLException {
        return null;
    }

    @Override
    public void insert(Films films) {
        em.persist(films);
    }
}
