package fr.diginamic.entities.embedded;

import fr.diginamic.entities.Realisateurs;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * Représente une clé composite pour l'entité FilmsRealisateurs.
 * Cette clé est composée de l'identifiant IMDb du film et de celui du réalisateurs.
 */

@Embeddable
public class FilmsRealisateursId implements Serializable {

    @Column(name = "id_films")
    private String filmsId;
    @Column(name = "id_realisateurs")
    private String realId;

    public FilmsRealisateursId() {
    }

    public FilmsRealisateursId(String filmsId, String realId) {
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
     * @return realId
     */
    public String getRealId() {
        return realId;
    }

    /**
     * @param realId
     */
    public void setRealId(String realId) {
        this.realId = realId;
    }
}
