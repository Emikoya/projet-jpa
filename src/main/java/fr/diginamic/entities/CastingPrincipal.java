package fr.diginamic.entities;

import javax.persistence.*;

/**
 * Défini la table de jointure entre Films et Acteurs pour le casting principal.
 */

@Entity
@Table(name="casting_principal")
public class CastingPrincipal {
    /**
     * Clés étrangères.
     */
    @Id
    @ManyToOne
    @JoinColumn(name = "id_film")
    private Films film;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_realisateurs")
    private Acteurs acteurs;

    public CastingPrincipal() {
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
     * @return acteurs
     */
    public Acteurs getActeurs() {
        return acteurs;
    }

    /**
     * @param acteurs
     */
    public void setActeurs(Acteurs acteurs) {
        this.acteurs = acteurs;
    }
}
