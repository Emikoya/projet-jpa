package fr.diginamic.entities;

import javax.persistence.*;

/**
 * Définit un lieu en entité
 */

@Entity
public class Lieux {

    /**
     * Clé primaire
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String etat;
    private String ville;
    private String libelle;

    /**
     * Clé étrangère vers l'entité Pays, représentant le pays du lieu.
     */
    @OneToOne
    @JoinColumn(name="nom_pays")
    private Pays pays;

    public Lieux() {
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
     * @return etat
     */
    public String getEtat() {
        return etat;
    }
    /**
     * @param etat
     */
    public void setEtat(String etat) {
        this.etat = etat;
    }

    /**
     * @return ville
     */
    public String getVille() {
        return ville;
    }
    /**
     * @param ville
     */
    public void setVille(String ville) {
        this.ville = ville;
    }

    /**
     * @return libelle
     */
    public String getLibelle() {
        return libelle;
    }
    /**
     * @param libelle
     */
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    /**
     * @return pays
     */
    public Pays getPays() {
        return pays;
    }
    /**
     * @param pays
     */
    public void setPays(Pays pays) {
        this.pays = pays;
    }
}
