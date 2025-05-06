package fr.diginamic.entities.base;

import javax.persistence.*;
import java.util.Date;

/**
 * Définit une personne
 */

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Personnes {

    /**
     * Clé Primaire
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idImdb;

    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String url;

    /**
     * Clé étrangère : l'id du lieu pour la naissance de la personne
     */
    @OneToOne
    @JoinColumn(name="id_lieux")
    private int idLieuNaissance;

    public Personnes() {
    }

    /**
     * @return idImdb
     */
    public int getIdImdb() {
        return idImdb;
    }

    /**
     * @param idImdb
     */
    public void setIdImdb(int idImdb) {
        this.idImdb = idImdb;
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
     * @return prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * @return dateNaissance
     */
    public Date getDateNaissance() {
        return dateNaissance;
    }

    /**
     * @param dateNaissance
     */
    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
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

    /**
     * @return idLieuNaissance
     */
    public int getIdLieuNaissance() {
        return idLieuNaissance;
    }

    /**
     * @param idLieuNaissance
     */
    public void setIdLieuNaissance(int idLieuNaissance) {
        this.idLieuNaissance = idLieuNaissance;
    }
}
