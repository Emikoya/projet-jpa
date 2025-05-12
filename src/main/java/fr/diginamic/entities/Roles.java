package fr.diginamic.entities;

import fr.diginamic.entities.embedded.RolesId;

import javax.persistence.*;

/**
 * Définition des rôles et de la jointure entre le film et les acteurs
 */
@Entity
@Table(name="roles")
public class Roles {
    @EmbeddedId
    private RolesId id;
    /**
     * Clés étrangères.
     */
    @ManyToOne
    @MapsId("filmsId")
    @JoinColumn(name = "id_films", referencedColumnName = "idImdb")
    private Films films;

    @ManyToOne
    @MapsId("acteursId")
    @JoinColumn(name = "id_acteurs", referencedColumnName = "idImdb")
    private Acteurs acteurs;

    private String personnage;

    public Roles() {
    }

    /**
     * @return film
     */
    public Films getFilms() {
        return films;
    }

    /**
     * @param films
     */
    public void setFilms(Films films) {
        this.films = films;
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

    /**
     * @return personnage
     */
    public String getPersonnage() {
        return personnage;
    }

    /**
     * @param personnage
     */
    public void setPersonnage(String personnage) {
        this.personnage = personnage;
    }
}
