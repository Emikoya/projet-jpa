package fr.diginamic.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.diginamic.entities.Lieux;
import fr.diginamic.entities.Pays;

import java.time.Year;

public class FilmsDto {
    @JsonProperty("id")
    private String idImdb;

    @JsonProperty("nom")
    private String titre;
    private Year annee;
    private Float rating;
    private String url;
    private String langue;
    @JsonProperty("plot")
    private String resume;

    @JsonProperty("lieuTournage")
    private Lieux lieux;

    private Pays pays;

    public FilmsDto() {
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
    public void setidImdb(String idImdb) {
        this.idImdb = idImdb;
    }

    /**
     * @return titre
     */
    public String getTitre() {
        return titre;
    }

    /**
     * @param titre
     */
    public void setTitre(String titre) {
        this.titre = titre;
    }

    /**
     * @return annee
     */
    public Year getAnnee() {
        return annee;
    }

    /**
     * @param annee
     */
    public void setAnnee(Year annee) {
        this.annee = annee;
    }

    /**
     * @return rating
     */
    public Float getRating() {
        return rating;
    }

    /**
     * @param rating
     */
    public void setRating(Float rating) {
        this.rating = rating;
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
     * @return langue
     */
    public String getLangue() {
        return langue;
    }

    /**
     * @param langue
     */
    public void setLangue(String langue) {
        this.langue = langue;
    }

    /**
     * @return resume
     */
    public String getResume() {
        return resume;
    }

    /**
     * @param resume
     */
    public void setResume(String resume) {
        this.resume = resume;
    }

    /**
     * @return lieux
     */
    public Lieux getLieux() {
        return lieux;
    }

    /**
     * @param lieux
     */
    public void setLieux(Lieux lieux) {
        this.lieux = lieux;
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
