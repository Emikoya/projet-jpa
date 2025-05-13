package fr.diginamic.services;

import fr.diginamic.dao.FilmsGenresDao;
import fr.diginamic.dao.GenresDao;
import fr.diginamic.dto.FilmsDto;
import fr.diginamic.entities.Films;
import fr.diginamic.entities.FilmsGenres;
import fr.diginamic.entities.Genres;
import fr.diginamic.entities.enums.GenresType;

import javax.persistence.EntityManager;


/**
 * Service responsable de la gestion des associations entre les films et leurs genres.
 */
public class FilmsGenresService {

    /**
     * On associe les genres à un film donné à partir du DTO.
     */
    public void insertData(EntityManager entityManager, Films films, FilmsDto dto) {
        try {
            GenresDao genresDao = new GenresDao(entityManager);
            FilmsGenresDao fgDao = new FilmsGenresDao(entityManager);


            for (String genreStr : dto.getGenres()) {
                try {
                    GenresType genreEnum = GenresType.valueOf(genreStr.toUpperCase());
                    Genres genre = genresDao.getOrCreate(genreEnum);
                    fgDao.getOrCreate(films, genre);
                } catch (IllegalArgumentException ex) {
                    System.err.println("Genre inconnu : " + genreStr);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Cette méthode permet d'instancier une transaction avec la base de données
     * en vérifiant l'existence du genre avec la méthode getOrCreate
     */
    public FilmsGenres getFilmsGenres(EntityManager entityManager, Films films, Genres genres) {
        FilmsGenres filmsGenres;

        try {
            FilmsGenresDao dao = new FilmsGenresDao(entityManager);
            filmsGenres = dao.getOrCreate(films, genres);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return filmsGenres;
    }
}

