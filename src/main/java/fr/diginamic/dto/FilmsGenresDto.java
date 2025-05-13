package fr.diginamic.dto;

/**
 * DTO représentant une jointure entre un film et un genre.
 * Utilisé pour transférer les données vers l'entité FilmsGenres.
 */
public class FilmsGenresDto {

    private FilmsDto film;
    private GenresDto genre;

    public FilmsGenresDto() {
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
     * @return genre
     */
    public GenresDto getGenre() {
        return genre;
    }

    /**
     * @param genre
     */
    public void setGenre(GenresDto genre) {
        this.genre = genre;
    }
}
