package fr.diginamic.dto;

/**
 * DTO représentant une jointure entre un film et un réalisateur.
 * Utilisé pour transférer les données vers l'entité FilmsRealisateurs.
 */
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
