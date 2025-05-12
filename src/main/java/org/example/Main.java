package org.example;

import fr.diginamic.services.DatabaseVerif;
import fr.diginamic.services.inserts.PaysInsert;

public class Main {
    public static void main(String[] args) throws Exception {

        // Vérification de l'existence de la base de donnée
        DatabaseVerif service = new DatabaseVerif();
        service.databaseVerif();

//        FilmsInsert insertFilms = new FilmsInsert();
//        insertFilms.insertData();

        PaysInsert insertPays = new PaysInsert();
        insertPays.insertData();

    }
}