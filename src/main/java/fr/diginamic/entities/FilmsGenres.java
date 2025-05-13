package fr.diginamic.entities;

import fr.diginamic.entities.embedded.FilmsGenresId;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Défini la table de jointure entre Films et Genres
 */

@Entity
@Table(name="films_genres")
public class FilmsGenres implements Serializable {

    @EmbeddedId
    private FilmsGenresId id;

    /**
     * Clés étrangères.
     */
    @ManyToOne
    @MapsId("filmsId")
    @JoinColumn(name = "id_film")
    private Films film;

    @ManyToOne
    @MapsId("genresId")
    @JoinColumn(name = "id_genre")
    private Genres genre;

    public FilmsGenres() {
    }

    /**
     * @return id
     */
    public FilmsGenresId getId() {
        return id;
    }
    /**
     * @param id
     */
    public void setId(FilmsGenresId id) {
        this.id = id;
    }

    /**
     * @return film
     */
    public Films getFilm() {
        return film;
    }

    /**
     * @param film
     */
    public void setFilm(Films film) {
        this.film = film;
        if (id == null) id = new FilmsGenresId();
        id.setFilmsId(film.getIdImdb());
    }

    /**
     * @return genre
     */
    public Genres getGenre() {
        return genre;
    }

    /**
     * @param genre
     */
    public void setGenre(Genres genre) {
        this.genre = genre;
        if (id == null) id = new FilmsGenresId();
        id.setGenresId(genre.getId());
    }
}
