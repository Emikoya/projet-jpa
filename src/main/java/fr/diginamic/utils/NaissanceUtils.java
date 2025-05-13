package fr.diginamic.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDate;

/**
 * Cette classe va permettre de parser la date et le lieu de naissance
 * présent dans le fichier Json
 */
public class NaissanceUtils {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static Naissance parseNaissance(String jsonString) {
        try {
            JsonNode root = objectMapper.readTree(jsonString);
            JsonNode naissanceNode = root.path("naissance");

            String dateNaissance = naissanceNode.path("dateNaissance").asText().trim();
            String lieuNaissance = naissanceNode.path("lieuNaissance").asText().trim();

            // On formate la date selon DateUtils
            LocalDate dateformat = DateUtils.parseDate(dateNaissance);

            return new Naissance(dateformat, lieuNaissance);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Classe interne pour représenter les données extraites
    public static class Naissance {
        private LocalDate dateNaissance;
        private String lieuNaissance;

        public Naissance(LocalDate dateNaissance, String lieuNaissance) {
            this.dateNaissance = dateNaissance;
            this.lieuNaissance = lieuNaissance;
        }

        public LocalDate getDateNaissance() {
            return dateNaissance;
        }

        public String getLieuNaissance() {
            return lieuNaissance;
        }

        @Override
        public String toString() {
            return "Naissance{" +
                    "dateNaissance=" + dateNaissance +
                    ", lieuNaissance='" + lieuNaissance + '\'' +
                    '}';
        }
    }
}
