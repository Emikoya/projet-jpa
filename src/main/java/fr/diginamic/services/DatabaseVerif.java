package fr.diginamic.services;

import fr.diginamic.utils.DatabaseUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Ce service va déclancher automatiquement l'utilitaire DatabaseUtils.
 * Cela se traduit par l'appel de la fonction createDatabase
 */
public class DatabaseVerif {
    private String dbName = "films_db";
    private String user = "root";
    private String password = "";
    private String url = "jdbc:mysql://localhost:3306/";

    public void databaseVerif() {
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            DatabaseUtils.createDatabase(conn, dbName);
        } catch (SQLException e) {
            System.err.println("Erreur lors de la vérification/création de la base de donnée : " + e.getMessage());
            e.printStackTrace();
        }
    }

}
