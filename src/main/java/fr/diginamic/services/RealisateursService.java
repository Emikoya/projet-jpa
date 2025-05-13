package fr.diginamic.services;

import fr.diginamic.dao.LieuxDao;
import fr.diginamic.dao.RealisateursDao;
import fr.diginamic.dto.RealisateursDto;
import fr.diginamic.entities.Lieux;
import fr.diginamic.entities.Pays;
import fr.diginamic.utils.DateUtils;
import fr.diginamic.utils.IdentiteUtils;
import fr.diginamic.utils.LieuUtils;
import fr.diginamic.utils.NaissanceUtils;

import javax.persistence.EntityManager;
import java.time.LocalDate;

public class RealisateursService {
    public void insertData(EntityManager entityManager, RealisateursDto dto) {
        // Traitement du nom et prénom
        String[] nomPrenom = IdentiteUtils.realisateursIdentite(dto.getIdentite());
        String prenom = nomPrenom[0];
        String nom = nomPrenom[1];

        // Traitement de la naissance
        NaissanceUtils.Naissance naissance = dto.getNaissance(); // Le JSON brut ou JsonNode
        // Traitement de date
        LocalDate dateNaissance = null;
        if (naissance != null) {
            // Utilisation de DateUtils pour parser la date
            dateNaissance = DateUtils.parseDate(naissance.getDateNaissance());
        }
        // Traitement de lieu
        String lieuNaissance = naissance != null ? naissance.getLieuNaissance() : null;
        String[] lieuParts = LieuUtils.lieuTraite(lieuNaissance);
        String etat = lieuParts[0];
        String ville = lieuParts[1];
        String pays = lieuParts[2];

        // Recherche du pays
        Pays paysLieu = PaysService.getPays(entityManager, pays, null);
        // Recherche ou création du lieu
        LieuxDao daoLieu = new LieuxDao(entityManager);
        Lieux lieux = new Lieux();
        lieux.setEtat(etat);
        lieux.setVille(ville);
        lieux.setPays(paysLieu);
        daoLieu.insert(lieux);


        // Création ou récupération du réalisateur
        RealisateursDao dao = new RealisateursDao(entityManager);
        dao.getOrCreate(
                dto.getIdImdb(),
                nom,
                prenom,
                dateNaissance,
                dto.getUrl(),
                lieux
        );
    }

}
