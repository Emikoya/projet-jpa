package fr.diginamic.dao;

import fr.diginamic.entities.Genres;
import fr.diginamic.entities.enums.GenresType;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.sql.SQLException;

/**
 * DAO pour accéder aux entités Genres en base de données.
 * Fournit des opérations de recherche, insertion & mise à jour.
 */
public class GenresDao implements InterfaceDao<Genres> {

    private EntityManager entityManager;

    public GenresDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Genres extraire(Genres genres) throws SQLException {
        return null;
    }

    @Override
    public void insert(Genres genres) {
        entityManager.persist(genres);
    }

    /**
     * Récupère un genre existant par son nom, ou le crée s'il n'existe pas encore.
     */
    public Genres getOrCreate(GenresType nom) {
        try {
            TypedQuery<Genres> query = entityManager.createQuery(
                    "SELECT g FROM Genres g WHERE g.nom = :nom", Genres.class);
            query.setParameter("nom", nom);
            return query.getSingleResult();
        } catch (NoResultException e) {
            Genres genres = new Genres();
            genres.setNom(nom);
            insert(genres);
            return genres;
        }
    }
}
