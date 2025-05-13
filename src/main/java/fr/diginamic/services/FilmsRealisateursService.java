package fr.diginamic.services;

import fr.diginamic.dao.FilmsRealisateursDao;
import fr.diginamic.dao.RealisateursDao;
import fr.diginamic.dto.FilmsDto;
import fr.diginamic.dto.RealisateursDto;
import fr.diginamic.entities.Films;
import fr.diginamic.entities.Realisateurs;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Service responsable de la gestion des associations entre les films et les réalisateurs.
 */
public class FilmsRealisateursService {

    /**
     * Associe tous les réalisateurs d’un film (déjà présents en base) à un film donné.
     */
    public void insertData(EntityManager entityManager, Films film, FilmsDto dto) {
        List<RealisateursDto> realisateursDtos = dto.getRealisateurs();

        if (realisateursDtos == null || realisateursDtos.isEmpty()) {
            System.out.println("Aucun réalisateur à associer au film " + film.getTitre());
            return;
        }

        FilmsRealisateursDao filmsRealisateursDao = new FilmsRealisateursDao(entityManager);
        RealisateursDao realDao = new RealisateursDao(entityManager);

        for (RealisateursDto realDto : realisateursDtos) {
            try {
                // Le réalisateur est déjà inséré auparavant, donc on le récupère seulement
                Realisateurs realisateur = realDao.getByIdImdb(realDto.getIdImdb());

                if (realisateur != null) {
                    // Créer l'association Film <-> Réalisateur
                    filmsRealisateursDao.getOrCreate(film, realisateur);
                } else {
                    System.err.println("Réalisateur introuvable pour l'ID : " + realDto.getIdImdb());
                }

            } catch (Exception ex) {
                System.err.println("Erreur lors de l'association du réalisateur " + realDto.getIdentite()
                        + " au film " + film.getTitre());
                ex.printStackTrace();
            }
        }
    }
}
