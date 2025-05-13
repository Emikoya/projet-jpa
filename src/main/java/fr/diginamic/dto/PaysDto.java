package fr.diginamic.dto;

/**
 * DTO représentant un pays tel qu'il est défini dans le fichier JSON.
 * Utilisé pour transférer les données vers l'entité Pays.
 */
public class PaysDto {

    private String nom;
    private String url;

    public PaysDto() {
    }

    public PaysDto(String nom, String url) {
        this.nom = nom;
        this.url = url;
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
