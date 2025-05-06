package fr.diginamic.entities;

import javax.persistence.*;

/**
 * Définition des rôles et de la jointure entre le film et les acteurs
 */
@Entity
@Table(name="roles")
public class Roles {
    /**
     * Clés étrangères.
     */
    @Id
    @ManyToOne
    @JoinColumn(name = "id_film")
    private Films film;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_acteurs")
    private Acteurs acteurs;

    private String personnage;

    public Roles() {
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
