package fr.diginamic.dao;

import fr.diginamic.entities.*;
import fr.diginamic.entities.embedded.FilmsRealisateursId;

import javax.persistence.EntityManager;
import java.sql.SQLException;

public class FilmsRealisateursDao implements InterfaceDao<FilmsRealisateurs>{

    EntityManager entityManager;

    public FilmsRealisateursDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public FilmsRealisateurs extraire(FilmsRealisateurs entity) throws SQLException {
        return null;
    }

    @Override
    public void insert(FilmsRealisateurs fm) {
        entityManager.persist(fm);
    }

    public FilmsRealisateurs getOrCreate(Films film, Realisateurs realisateur) {
        if (film == null || film.getIdImdb() == null) {
            throw new IllegalArgumentException("Film ou son ID est null");
        }
        if (realisateur == null || realisateur.getIdImdb() == null) {
            throw new IllegalArgumentException("Réalisateur ou son ID est null");
        }

        FilmsRealisateursId id = new FilmsRealisateursId(
                film.getIdImdb(),
                realisateur.getIdImdb()
        );

        FilmsRealisateurs existing = entityManager.find(FilmsRealisateurs.class, id);
        if (existing == null) {
            FilmsRealisateurs fr = new FilmsRealisateurs();
            fr.setFilm(film);
            fr.setRealisateurs(realisateur);
            insert(fr);
            return fr;
        }
        return existing;
    }

}
