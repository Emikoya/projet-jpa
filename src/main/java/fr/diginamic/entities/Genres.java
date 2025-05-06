package fr.diginamic.entities;

import fr.diginamic.entities.enums.GenresType;

import javax.persistence.*;

/**
 * Définit les genres cinématographiques
 */

@Entity
public class Genres {
    /**
     * Clé Primaire
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    /**
     * Le genre du film sous forme énumérée (ex. ACTION, COMEDY, etc.).
     */
    @Enumerated(EnumType.STRING)
    private GenresType nom;

    public Genres() {
    }

    /**
     * @return id
     */
    public int getId() {
        return id;
    }
    /**
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return nom
     */
    public GenresType getNom() {
        return nom;
    }
    /**
     * @param nom
     */
    public void setNom(GenresType nom) {
        this.nom = nom;
    }
}
