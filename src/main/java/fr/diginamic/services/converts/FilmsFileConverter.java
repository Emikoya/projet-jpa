package fr.diginamic.services.converts;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.diginamic.dao.FilmsGenresDao;
import fr.diginamic.dao.GenresDao;
import fr.diginamic.dto.FilmsDto;
import fr.diginamic.dto.LieuxDto;
import fr.diginamic.entities.*;
import fr.diginamic.entities.enums.GenresType;
import fr.diginamic.services.GenresService;
import fr.diginamic.services.LieuxService;
import fr.diginamic.services.PaysService;
import fr.diginamic.utils.DateUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
    public static Films toEntity(EntityManager entityManager, FilmsDto dto) throws SQLException {
        Films films = new Films();
        // Récuparation des attributs de Films
        films.setIdImdb(dto.getIdImdb());
        films.setTitre(dto.getTitre());
        films.setLangue(dto.getLangue());
        films.setUrl(dto.getUrl());
        films.setResume(dto.getResume());
        films.setRating(dto.getRating());
        films.setAnnee(Integer.parseInt(dto.getAnnee()));
        // Récupération du pays principal du film
        PaysService paysService = new PaysService();
        Pays pays = paysService.getPays(entityManager, dto.getPays().getNom(), dto.getPays().getUrl());
        films.setPays(pays);
        // Récupération du lieu de tournage (ville, état, pays)
        LieuxService lieuxService = new LieuxService();
        LieuxDto lieuDto = dto.getLieux();
        Pays paysLieu = paysService.getPays(entityManager, lieuDto.getPays(), null);
        Lieux lieux = lieuxService.getLieux(
                entityManager,
                lieuDto.getId(),
                lieuDto.getEtat(),
                lieuDto.getVille(),
                paysLieu
        );
        films.setLieux(lieux);

        return films;
    }
}
