package fr.diginamic.entities;

import fr.diginamic.entities.embedded.FilmsRealisateursId;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Défini la table de jointure entre Films et Realisateurs
 */

@Entity
public class FilmsRealisateurs implements Serializable {

    @EmbeddedId
    private FilmsRealisateursId id;

    /**
     * Clés étrangères.
     */
    @ManyToOne
    @MapsId("filmsId")
    @JoinColumn(name = "id_film")
    private Films film;

    @ManyToOne
    @MapsId("realId")
    @JoinColumn(name = "id_realisateur")
    private Realisateurs realisateurs;


    public FilmsRealisateurs() {
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
    }

    /**
     * @return realisateurs
     */
    public Realisateurs getRealisateurs() {
        return realisateurs;
    }

    /**
     * @param realisateurs
     */
    public void setRealisateurs(Realisateurs realisateurs) {
        this.realisateurs = realisateurs;
    }
}
