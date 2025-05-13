package fr.diginamic.entities;

import fr.diginamic.entities.enums.GenresType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Définit les genres cinématographiques en entité
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

    @OneToMany(mappedBy = "genre", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FilmsGenres> filmsGenres = new ArrayList<>();

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
