package fr.diginamic.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.diginamic.entities.Pays;

import java.util.List;

public class FilmsDto {
    @JsonProperty("id")
    private String idImdb;

    @JsonProperty("nom")
    private String titre;
    @JsonProperty("anneeSortie")
    private String annee;
    private Float rating;
    private String url;
    private String langue;
    @JsonProperty("plot")
    private String resume;

    @JsonProperty("lieuTournage")
    private LieuxDto lieux;

    private Pays pays;

    @JsonProperty("genres")
    private List<String> genres;

    @JsonProperty("realisateurs")
    private List<RealisateursDto> realisateurs;

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
    public String getAnnee() {
        return annee;
    }
    /**
     * @param annee
     */
    public void setAnnee(String annee) {
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
    public LieuxDto getLieux() {
        return lieux;
    }

    /**
     * @param lieux
     */
    public void setLieux(LieuxDto lieux) {
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

    /**
     * @return genres
     */
    public List<String> getGenres() {
        return genres;
    }

    /**
     * @param genres
     */
    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    /**
     * @return realisateurs
     */
    public List<RealisateursDto> getRealisateurs() {
        return realisateurs;
    }

    /**
     * @param realisateurs
     */
    public void setRealisateurs(List<RealisateursDto> realisateurs) {
        this.realisateurs = realisateurs;
    }
}
