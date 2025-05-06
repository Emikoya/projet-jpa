package fr.diginamic.entities;

import javax.persistence.*;

/**
 * Défini la table de jointure entre Films et Realisateurs
 */

@Entity
public class FilmsRealisateurs {
    /**
     * Clés étrangères.
     */
    @Id
    @ManyToOne
    @JoinColumn(name = "id_film")
    private Films film;

    @Id
    @ManyToOne
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
