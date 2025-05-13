package fr.diginamic.services;

import fr.diginamic.dao.PaysDao;
import fr.diginamic.dto.PaysDto;
import fr.diginamic.entities.Pays;
import fr.diginamic.services.converts.PaysFileConverter;

import javax.persistence.EntityManager;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

/**
 * Service chargé de la gestion de Pays.
 */
public class PaysService {

    /**
     * Récupère un pays depuis la base ou le crée s’il n’existe pas encore.
     * Ne gère pas la transaction (c’est Main qui le fait).
     */
    public static Pays getPays(EntityManager entityManager, String nomPays, String url) {
        try {
            PaysDao dao = new PaysDao(entityManager);
            return dao.getOrCreate(nomPays, url);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Insère tous les pays à partir du fichier CSV.
     * Ne gère pas de transaction (c’est Main qui le fait).
     */
    public void insertData(EntityManager entityManager) throws IOException {
        PaysFileConverter reader = new PaysFileConverter();
        List<PaysDto> dtos = reader.mapperCsv(Paths.get("src/main/resources/pays.csv"));

        PaysDao dao = new PaysDao(entityManager);

        try {
            for (PaysDto dto : dtos) {
                Pays pays = PaysFileConverter.toEntity(dto);
                dao.insert(pays);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
