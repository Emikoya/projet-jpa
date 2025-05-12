package fr.diginamic.services.converts;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.diginamic.dto.FilmsDto;
import fr.diginamic.entities.Films;
import fr.diginamic.entities.Pays;
import fr.diginamic.services.PaysService;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Cette classe sera utilisée pour lire le fichier json
 * Ainsi que mapper chaque donnée pour les convertir en entité
 */

public class FilmsFileConverter {

    /**
     * Lecture et mappage du fichier json
     */
    public List<FilmsDto> mapperJson(String path) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return List.of(mapper.readValue(new File(path), FilmsDto[].class));
    }

    /**
     * Mappage des données
     */
    public static Films toEntity(FilmsDto dto) throws SQLException {
        Films films = new Films();
        films.setIdImdb(dto.getIdImdb());
        films.setTitre(dto.getTitre());
        films.setAnnee(dto.getAnnee());
        films.setLangue(dto.getLangue());
        films.setUrl(dto.getUrl());
        films.setResume(dto.getResume());
        films.setRating(dto.getRating());
        // TODO: gérer aussi les genres, pays, lieux s’ils existent
        PaysService paysService = new PaysService();
        Pays pays = paysService.getOrCreate(dto.getPays().getNom(), dto.getPays().getUrl());
        films.setPays(pays);
        return films;
    }
}
