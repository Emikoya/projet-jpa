package fr.diginamic.services.inserts;

import fr.diginamic.dao.FilmsDao;
import fr.diginamic.dto.FilmsDto;
import fr.diginamic.dto.RealisateursDto;
import fr.diginamic.entities.Films;
import fr.diginamic.services.FilmsRealisateursService;
import fr.diginamic.services.RealisateursService;
import fr.diginamic.services.converts.FilmsFileConverter;
import fr.diginamic.services.FilmsGenresService;

import javax.persistence.EntityManager;
import java.io.IOException;
import java.util.List;

/**
 * Cette classe permet d'instancier une transaction avec la base de données
 * afin d'insérer les données d'un film d'un fichier json.
 */

public class FilmsInsertService {
    public void insertData(EntityManager entityManager) throws IOException {
        FilmsFileConverter reader = new FilmsFileConverter();
        List<FilmsDto> dtos = reader.mapperJson("src/main/resources/filmstest.json");

        FilmsDao daoFilms = new FilmsDao(entityManager);
        FilmsGenresService fgService = new FilmsGenresService();
        RealisateursService realService = new RealisateursService();
        FilmsRealisateursService fmService = new FilmsRealisateursService();

        try {
            for (FilmsDto dto : dtos) {
                Films film = daoFilms.getOrCreate(dto);

                // Ajout des genres associés
                fgService.insertData(entityManager, film, dto);

                // Ajout des réalisateurs
                List<RealisateursDto> realDtos = dto.getRealisateurs();
                for (RealisateursDto realDto : realDtos) {
                    realService.insertData(entityManager, realDto);
                }

                // Puis la jointure
                fmService.insertData(entityManager, film, dto);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
