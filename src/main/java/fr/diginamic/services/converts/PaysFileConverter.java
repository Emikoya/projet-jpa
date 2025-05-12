package fr.diginamic.services.converts;

import fr.diginamic.dto.PaysDto;
import fr.diginamic.entities.Pays;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Cette classe sera utilisée pour lire le fichier csv
 * Ainsi que mapper chaque donnée pour les convertir en entité
 */
public class PaysFileConverter {


    /**
     * Lecture du fichier csv
     */
    public List<PaysDto> mapperCsv(Path path) throws IOException {

        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

        List<PaysDto> paysList = new ArrayList<>();
        for (String line : lines){
            String[] tokens = line.split(";");
            if(!Objects.equals(tokens[0], "NOM")){
                String nom = tokens[0];
                String url = tokens[1];
                paysList.add(new PaysDto(nom, url));
            }
        }

        return paysList;
    }

    /**
     * Mappage des données
     */
    public static Pays toEntity(PaysDto dto) {
        Pays pays = new Pays();
        pays.setNom(dto.getNom());
        pays.setUrl(dto.getUrl());
        return pays;
    }

}
