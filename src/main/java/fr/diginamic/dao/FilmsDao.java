package fr.diginamic.dao;

import fr.diginamic.dto.FilmsDto;
import fr.diginamic.entities.Films;
import fr.diginamic.services.converts.FilmsFileConverter;

import javax.persistence.EntityManager;
import java.sql.SQLException;

/**
 * DAO pour accéder aux entités Films en base de données.
 * Fournit des opérations de recherche, insertion & mise à jour.
 */
public class FilmsDao implements InterfaceDao<Films>{

    private EntityManager entityManager;

    public FilmsDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Films extraire(Films films) throws SQLException {
        return null;
    }

    @Override
    public void insert(Films films) {
        entityManager.persist(films);
    }

    public Films getOrCreate(FilmsDto dto) throws SQLException {
        Films existing = entityManager.find(Films.class, dto.getIdImdb());
        if (existing != null) {
            return existing;
        }

        Films film = FilmsFileConverter.toEntity(entityManager, dto);
        insert(film);
        return film;
    }
}
