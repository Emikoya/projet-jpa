package fr.diginamic.entities;

import javax.persistence.*;

/**
 * Définit un pays
 */


@Entity
@Table(name="pays")
public class Pays {

    /**
     * La clé primaire sera le nom du pays
     */
    @Id
    private String nom;

    private String url;

    public Pays() {
    }

    public Pays(String nomPays) {
    }

    /**
     * @return nom
     */
    public String getNom() {
        return nom;
    }
    /**
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return url
     */
    public String getUrl() {
        return url;
    }
    /**
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }
}
