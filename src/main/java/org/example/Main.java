package org.example;

import fr.diginamic.services.DatabaseVerif;


public class Main {
    public static void main(String[] args) throws Exception {

        DatabaseVerif service = new DatabaseVerif();
        service.databaseVerif();

    }
}