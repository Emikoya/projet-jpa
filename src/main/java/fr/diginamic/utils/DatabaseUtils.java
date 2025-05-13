package fr.diginamic.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Cette classe va permettre de vérifier si la base de donnée existe,
 * sinon on la crée. Elle permet d'éviter de la créer manuellement.
 */
public class DatabaseUtils {

    /**
     * Vérifie si une base de données existe.
     */
    public static boolean databaseExists(Connection connection, String dbName) throws SQLException {
        try (ResultSet resultSet = connection.getMetaData().getCatalogs()) {
            while (resultSet.next()) {
                String dataCursor = resultSet.getString(1);
                if (dataCursor.equalsIgnoreCase(dbName)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Crée la base de données.
     * On appelle la fonction databaseExist afin de vérifier si
     * la basse de donnée existe ou non.
     */
    public static void createDatabase(Connection connection, String dbName) throws SQLException {
        if (!databaseExists(connection, dbName)) {
            try (Statement stmt = connection.createStatement()) {
                String createDbSQL = "CREATE DATABASE " + dbName;
                stmt.executeUpdate(createDbSQL);
                System.out.println("Base de données '" + dbName + "' créée avec succès.");
            }
        } else {
            System.out.println("La base de données '" + dbName + "' existe déjà.");
        }
    }
}
