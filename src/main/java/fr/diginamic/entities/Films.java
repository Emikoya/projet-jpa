package fr.diginamic.entities;

import javax.persistence.*;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

/**
 * Définit un film
 */


@Entity
@Table(name="films")
public class Films {

    /**
     * Clé Primaire
     * Elle vient d'Internet Movie Database, une grande base de donnée sur les films.
     * C'est une indentification particulière, pas composés d'entiers, mais une suite de chiffres
     * et de lettres
     */
    @Id
    private String idIMDB;

    private String titre;
    private Year annee;
    private Float rating;
    private String url;
    private String langue;
    private String resume;

    /**
     * Clés Etrangères
     */
    @OneToMany
    @JoinColumn(name="id_lieux_tournage")
    private Lieux lieux;
    @OneToMany
    @JoinColumn(name="nom_pays")
    private Pays pays;

    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FilmsGenres> filmsGenres = new ArrayList<>();

    public Films() {
    }

    /**
     * @return idIMDB
     */
    public String getIdIMDB() {
        return idIMDB;
    }
    /**
     * @param idIMDB
     */
    public void setIdIMDB(String idIMDB) {
        this.idIMDB = idIMDB;
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
     * @return idLieuxTournage
     */
    public int getLieux() {
        return lieux;
    }

    /**
     * @param lieux
     */
    public void setLieux(int lieux) {
        this.lieux = lieux;
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
