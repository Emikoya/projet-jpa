package fr.diginamic.dto;

import fr.diginamic.entities.enums.GenresType;

/**
 * DTO représentant un genre tel qu'il est défini dans l'enum ou le fichier JSON.
 * Utilisé pour transférer les données vers l'entité Genres.
 */
public class GenresDto {
    private int id;
    private GenresType nom;

    public GenresDto() {
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
