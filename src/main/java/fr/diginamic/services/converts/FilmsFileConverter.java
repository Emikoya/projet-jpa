package fr.diginamic.services.converts;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.diginamic.dto.FilmsDto;
import fr.diginamic.dto.LieuxDto;
import fr.diginamic.entities.Films;
import fr.diginamic.entities.Lieux;
import fr.diginamic.entities.Pays;
import fr.diginamic.services.LieuxService;
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
        // Récupération du pays principal du film
        PaysService paysService = new PaysService();
        Pays pays = paysService.getPays(dto.getPays().getNom(), dto.getPays().getUrl());
        films.setPays(pays);

        // Récupération du lieu de tournage (ville, état, pays)
        LieuxService lieuxService = new LieuxService();
        LieuxDto lieuDto = dto.getLieux();
        Pays paysLieu = paysService.getPays(lieuDto.getPays(), null); // URL souvent absente ici

        Lieux lieux = lieuxService.getLieux(
                lieuDto.getId(),
                lieuDto.getEtat(),
                lieuDto.getVille(),
                paysLieu
        );
        films.setLieux(lieux);

        return films;
    }
}
