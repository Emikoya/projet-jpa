package fr.diginamic.entities;

import fr.diginamic.entities.embedded.CastingPrincipalId;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Défini la table de jointure entre Films et Acteurs pour le casting principal.
 */

@Entity
@Table(name="casting_principal")
public class CastingPrincipal implements Serializable {

    @EmbeddedId
    private CastingPrincipalId id;
    /**
     * Clés étrangères.
     */
    @ManyToOne
    @MapsId("filmsId")
    @JoinColumn(name = "id_film", referencedColumnName = "idImdb")
    private Films film;

    @ManyToOne
    @MapsId("acteursId")
    @JoinColumn(name = "id_realisateurs", referencedColumnName = "idImdb")
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
