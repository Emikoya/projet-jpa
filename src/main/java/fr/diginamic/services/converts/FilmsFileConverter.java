package fr.diginamic.services.converts;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.diginamic.dto.FilmsDto;
import fr.diginamic.entities.Films;

import java.io.File;
import java.io.IOException;
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
        return mapper.readValue(new File(path), new TypeReference<List<FilmsDto>>() {});
    }

    /**
     * Mappage des données
     */
    public static Films toEntity(FilmsDto dto) {
        Films film = new Films();
        film.setIdImdb(dto.getIdImdb());
        film.setTitre(dto.getTitre());
        film.setAnnee(dto.getAnnee());
        film.setLangue(dto.getLangue());
        film.setUrl(dto.getUrl());
        film.setResume(dto.getResume());
        film.setRating(dto.getRating());
        // TODO: gérer aussi les genres, pays, lieux s’ils existent
        return film;
    }
}
