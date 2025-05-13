package fr.diginamic.services;

import fr.diginamic.dao.GenresDao;
import fr.diginamic.entities.Genres;
import fr.diginamic.entities.enums.GenresType;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;


public class GenresService {

    /**
     * Cette méthode permet d'instancier une transaction avec la base de données
     * en vérifiant l'existence du genre avec la méthode getOrCreate
     */
    public Genres getGenres(EntityManager entityManager, GenresType nom) {
        Genres genres;

        try {
            GenresDao dao = new GenresDao(entityManager);
            genres = dao.getOrCreate(nom);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return genres;
    }

    /**
     * Cette méthode permet d'insérer les données de la classe enum GenresTypes.
     * La gestion des transactions est centralisée ailleurs.
     */
    public void insertData(EntityManager entityManager){

        GenresDao genresDao = new GenresDao(entityManager);

        try {
            for (GenresType type : GenresType.values()) {
                Genres genre = new Genres();
                genre.setNom(type);
                genresDao.insert(genre);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

