package fr.diginamic.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LieuxDto {
    private int id;

    @JsonProperty("etatDept")
    private String etat;
    private String ville;
    private String libelle;

    private String pays;

    public LieuxDto() {
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
    public String getPays() {
        return pays;
    }

    /**
     * @param pays
     */
    public void setPays(String pays) {
        this.pays = pays;
    }
}
