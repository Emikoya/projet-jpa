package fr.diginamic.entities.embedded;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * Définit une classe composée afin d'établir le lien entre les clés étrangères
 */

@Embeddable
public class FilmsRealisateursId implements Serializable {
    private String filmsId;
    private int realId;

    public FilmsRealisateursId() {
    }

    public FilmsRealisateursId(String filmsId, int realId) {
        this.filmsId = filmsId;
        this.realId = realId;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        FilmsRealisateursId that = (FilmsRealisateursId) object;
        return realId == that.realId && Objects.equals(filmsId, that.filmsId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmsId, realId);
    }
}
