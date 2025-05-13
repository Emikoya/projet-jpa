package fr.diginamic.dto;

public class FilmsRealisateursDto {

    private FilmsDto film;
    private RealisateursDto realisateurs;

    public FilmsRealisateursDto() {
    }

    /**
     * @return film
     */
    public FilmsDto getFilm() {
        return film;
    }

    /**
     * @param film
     */
    public void setFilm(FilmsDto film) {
        this.film = film;
    }

    /**
     * @return realisateurs
     */
    public RealisateursDto getRealisateurs() {
        return realisateurs;
    }

    /**
     * @param realisateurs
     */
    public void setRealisateurs(RealisateursDto realisateurs) {
        this.realisateurs = realisateurs;
    }
}
