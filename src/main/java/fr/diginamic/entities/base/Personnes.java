package fr.diginamic.entities.base;

import fr.diginamic.entities.Lieux;
import fr.diginamic.entities.Realisateurs;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

/**
 * Définit une personne. Elle sera la classe mère d'Acteurs et Realisateurs
 */

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Personnes {

    /**
     * Clé Primaire
     */
    @Id
    @Column(name = "idImdb")
    private String idImdb;

    private String nom;
    private String prenom;
    @Column(name = "date_naissance")
    private LocalDate dateNaissance;
    private String url;

    /**
     * Clé étrangère : l'id du lieu pour la naissance de la personne
     */
    @OneToOne
    @JoinColumn(name="id_lieux")
    private Lieux idLieuNaissance;

    public Personnes() {
    }

    /**
     * @return idImdb
     */
    public String getIdImdb() {
        return idImdb;
    }
    /**
     * @param idImdb
     */
    public void setIdImdb(String idImdb) {
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
    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    /**
     * @param dateNaissance
     */
    public void setDateNaissance(LocalDate dateNaissance) {
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
    public Lieux getIdLieuNaissance() {
        return idLieuNaissance;
    }
    /**
     * @param idLieuNaissance
     */
    public void setIdLieuNaissance(Lieux idLieuNaissance) {
        this.idLieuNaissance = idLieuNaissance;
    }
}
