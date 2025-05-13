package fr.diginamic.utils;

import java.util.Arrays;

/**
 * Cette classe va permettre de traité les lieux qui sont sur une seule ligne
 * comme le lieu de naissance
 */
public class LieuUtils {

    public static String[] lieuTraite(String lieu) {
        if (lieu == null || lieu.trim().isEmpty()) {
            return new String[]{"", "", ""};
        }

        String[] lieuParts = lieu.trim().split(", ");

        String etat = lieuParts[0];
        String ville = lieuParts[1];
        String pays = lieuParts[2];
        return new String[]{etat, ville, pays};
    }
}
