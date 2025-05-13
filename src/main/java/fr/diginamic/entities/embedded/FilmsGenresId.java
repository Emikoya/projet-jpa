package fr.diginamic.entities.embedded;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * Représente une clé composite pour l'entité FilmsGenres.
 * Cette clé est composée de l'identifiant IMDb du film et de l'id du genre.
 */

@Embeddable
public class FilmsGenresId implements Serializable {
    @Column(name = "films_id")
    private String filmsId;

    @Column(name = "genres_id")
    private Integer genresId;

    public FilmsGenresId() {
    }

    public FilmsGenresId(String films, int genres) {
        this.filmsId = films;
        this.genresId = genres;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        FilmsGenresId that = (FilmsGenresId) object;
        return genresId == that.genresId && Objects.equals(filmsId, that.filmsId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmsId, genresId);
    }

    /**
     * @return filmsId
     */
    public String getFilmsId() {
        return filmsId;
    }

    /**
     * @param filmsId
     */
    public void setFilmsId(String filmsId) {
        this.filmsId = filmsId;
    }

    /**
     * @return genresId
     */
    public int getGenresId() {
        return genresId;
    }

    /**
     * @param genresId
     */
    public void setGenresId(int genresId) {
        this.genresId = genresId;
    }
}
