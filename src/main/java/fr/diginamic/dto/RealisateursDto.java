package fr.diginamic.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.diginamic.utils.NaissanceUtils;

public class RealisateursDto {

    @JsonProperty("id")
    private String idImdb;

    private String identite;
    private String url;

    @JsonProperty("naissance")
    private NaissanceUtils.Naissance naissance;

    public RealisateursDto() {
    }

    /**
     * @return idImdb
     */
    public String getIdImdb() {
        return idImdb;
    }

    /**
     * @return identite
     */
    public String getIdentite() {
        return identite;
    }

    /**
     * @param identite
     */
    public void setIdentite(String identite) {
        this.identite = identite;
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
     * @return naissance
     */
    public NaissanceUtils.Naissance getNaissance() {
        return naissance;
    }

    /**
     * @param naissance
     */
    public void setNaissance(NaissanceUtils.Naissance naissance) {
        this.naissance = naissance;
    }
}
