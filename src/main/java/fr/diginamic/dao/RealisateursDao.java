package fr.diginamic.dao;

import fr.diginamic.entities.Lieux;
import fr.diginamic.entities.Realisateurs;

import javax.persistence.EntityManager;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 * DAO pour accéder aux entités Realisateurs en base de données.
 * Fournit des opérations de recherche, insertion & mise à jour.
 */
public class RealisateursDao implements InterfaceDao<Realisateurs> {

    EntityManager entityManager;

    public RealisateursDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Realisateurs extraire(Realisateurs entity) throws SQLException {
        return null;
    }

    @Override
    public void insert(Realisateurs realisateurs) {
        entityManager.persist(realisateurs);
    }

    public Realisateurs getByIdImdb(String idImdb) {
        return entityManager.find(Realisateurs.class, idImdb);
    }

    /**
     * Récupère un realisateur existant par son nom, ou le crée s'il n'existe pas encore.
     */
    public Realisateurs getOrCreate(String idImdb, String nom, String prenom, LocalDate dateNaissance, String url, Lieux lieuNaissance) {
        Realisateurs realisateurs = getByIdImdb(idImdb);
        if (realisateurs == null) {
            realisateurs = new Realisateurs();
            realisateurs.setIdImdb(idImdb);
            realisateurs.setNom(nom);
            realisateurs.setPrenom(prenom);
            realisateurs.setDateNaissance(dateNaissance);
            realisateurs.setUrl(url);
            realisateurs.setIdLieuNaissance(lieuNaissance);
            insert(realisateurs);
        }
        return realisateurs;
    }
}
