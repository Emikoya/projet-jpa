package fr.diginamic.dao;

import fr.diginamic.entities.Films;

import javax.persistence.EntityManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
