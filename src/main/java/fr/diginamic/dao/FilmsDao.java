package fr.diginamic.dao;

import fr.diginamic.entities.Films;
import fr.diginamic.services.ConnectionDatabase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FilmsDao implements InterfaceDao{
    Connection database = ConnectionDatabase.getConnection();
    Statement monStatement = database.createStatement();

    public FilmsDao() throws SQLException {
    }

    @Override
    public List extraire() throws SQLException {
        List<Films> films = new ArrayList<>();

        try (PreparedStatement preparedStatement = database.prepareStatement("SELECT id, nom FROM fournisseur");
             ResultSet curseur = preparedStatement.executeQuery()) {

            while (curseur.next()) {

                films.add(new Films());
            }
        }

        return films;
    }

    @Override
    public void insert(Object entity) {

    }

    @Override
    public int update(Object entity) throws SQLException {
        return 0;
    }

    @Override
    public boolean delete(Object entity) throws SQLException {
        return false;
    }
}
