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


            return new Naissance(dateNaissance, lieuNaissance);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Classe interne pour représenter les données extraites
    public static class Naissance {
        private String dateNaissance;
        private String lieuNaissance;

        public Naissance() {
        }

        public Naissance(String dateNaissance, String lieuNaissance) {
            this.dateNaissance = dateNaissance;
            this.lieuNaissance = lieuNaissance;
        }

        public String getDateNaissance() {
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
