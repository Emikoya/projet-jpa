package fr.diginamic.entities.embedded;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * Définit une classe composée afin d'établir le lien entre les clés étrangères
 */

@Embeddable
public class FilmsGenresId implements Serializable {
    private String filmsId;
    private int genresId;

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
}
