package fr.diginamic.services.inserts;

import fr.diginamic.dao.PaysDao;
import fr.diginamic.dto.PaysDto;
import fr.diginamic.entities.Pays;
import fr.diginamic.services.converts.PaysFileConverter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

/**
 * Cette classe permet d'instancier une transaction avec la base de données
 * afin d'insérer les données d'un pays d'un fichier csv.
 */

public class PaysInsertService {
    public void insertData(EntityManager entityManager) throws IOException {

        PaysFileConverter reader = new PaysFileConverter();
        List<PaysDto> dtos = reader.mapperCsv(Paths.get("src/main/resources/pays.csv"));

        PaysDao dao = new PaysDao(entityManager);

        try {
            entityManager.getTransaction().begin();

            for (PaysDto dto : dtos) {
                Pays pays = PaysFileConverter.toEntity(dto);
                dao.insert(pays);
            }

            entityManager.getTransaction().commit();

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException(e);
        } finally {
            entityManager.close();
        }
    }
}
