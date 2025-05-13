package fr.diginamic.dao;

import fr.diginamic.entities.Films;
import fr.diginamic.entities.FilmsGenres;
import fr.diginamic.entities.Genres;
import fr.diginamic.entities.embedded.FilmsGenresId;

import javax.persistence.EntityManager;
import java.sql.SQLException;

public class FilmsGenresDao implements InterfaceDao<FilmsGenres>{
    private EntityManager entityManager;

    public FilmsGenresDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public FilmsGenres extraire(FilmsGenres entity) throws SQLException {
        return null;
    }

    @Override
    public void insert(FilmsGenres filmsGenres) {
        entityManager.persist(filmsGenres);
    }

    public FilmsGenres getOrCreate(Films films, Genres genres) {
        FilmsGenresId id = new FilmsGenresId();
        id.setFilmsId(films.getIdImdb());
        id.setGenresId(genres.getId());

        FilmsGenres existing = entityManager.find(FilmsGenres.class, id);
        if (existing == null) {
            FilmsGenres filmsGenres = new FilmsGenres();
            filmsGenres.setFilm(films);
            filmsGenres.setGenre(genres);
            insert(filmsGenres);
            return filmsGenres;
        }
        return existing;
    }
}
