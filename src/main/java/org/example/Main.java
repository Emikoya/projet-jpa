package org.example;

import fr.diginamic.utils.DatabaseUtils;

import java.sql.Connection;
import java.sql.DriverManager;


public class Main {
    public static void main(String[] args) throws Exception {

        String dbName = "films_db";
        String user = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:3306/";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            DatabaseUtils.createDatabase(conn, dbName);
        }

    }
}