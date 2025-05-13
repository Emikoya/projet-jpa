package fr.diginamic.utils;

import java.util.Arrays;

/**
 * Cette classe permet de séparer le nom et le prénom d'un individu
 * présent dans le fichier Json
 */

public class IdentiteUtils {

    public static String[] realisateursIdentite(String identite) {
        if (identite == null || identite.trim().isEmpty()) {
            return new String[]{"", ""};
        }

        String[] identiteParts = identite.trim().split(" ");

        String prenom = identiteParts[0];
        String nom = String.join(" ", Arrays.copyOfRange(identiteParts, 1, identiteParts.length));
        return new String[]{prenom, nom};
    }
}
