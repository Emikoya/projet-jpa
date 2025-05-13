package fr.diginamic.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

/**
 * Mise en place du format de la date
 */

public class DateUtils {

    public static LocalDate parseDate(String dateString) {
        if (dateString == null || dateString.trim().isEmpty()) {
            return null;
        }

        // Supprimer les espaces avant et après la date
        dateString = dateString.trim();

        // Afficher la chaîne avant de tenter de la parser
        System.out.println("Tentative de parsing de la date: '" + dateString + "'");

        DateTimeFormatter[] formatters = new DateTimeFormatter[]{
                DateTimeFormatter.ofPattern("MMM d yyyy", Locale.ENGLISH), // Mois abrégé
                DateTimeFormatter.ofPattern("MMMM d yyyy", Locale.ENGLISH), // Mois complet
                DateTimeFormatter.ofPattern("MMMM dd yyyy", Locale.ENGLISH), // Mois complet avec 2 chiffres pour le jour
                DateTimeFormatter.ofPattern("yyyy", Locale.ENGLISH), // Année seulement
                DateTimeFormatter.ofPattern("MMMM yyyy", Locale.ENGLISH), // Mois complet et année
                DateTimeFormatter.ofPattern("M/d/yyyy", Locale.ENGLISH) // Format "M/d/yyyy"
        };

        for (DateTimeFormatter formatter : formatters) {
            try {
                // Essayer de parser avec chaque format
                return LocalDate.parse(dateString, formatter);
            } catch (DateTimeParseException e) {
                // Afficher l'exception complète pour aider à la détection des erreurs
                System.out.println("Erreur de parsing pour le format: " + formatter);
                System.out.println("Exception: " + e.getMessage());
            }
        }

        // Si aucune des méthodes n'a fonctionné, lancer une exception avec plus de détails
        throw new IllegalArgumentException("Impossible de parser la date: " + dateString);
    }

    public static Integer parseYear(String dateString) {
        LocalDate parsedDate = parseDate(dateString);
        return (parsedDate != null) ? parsedDate.getYear() : null;
    }
}
