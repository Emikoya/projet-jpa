package fr.diginamic.entities.embedded;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * Représente une clé composite pour l'entité Roles.
 * Cette clé est composée de l'identifiant IMDb du film et de celui de l'acteur.
 */

@Embeddable
public class RolesId implements Serializable {

    @Column(name = "id_films")
    private String filmsId;
    @Column(name = "id_acteurs")
    private String acteursId;

    public RolesId() {
    }

    public RolesId(String filmsId, String acteursId) {
        this.filmsId = filmsId;
        this.acteursId = acteursId;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        RolesId rolesId = (RolesId) object;
        return Objects.equals(acteursId, rolesId.acteursId) && Objects.equals(filmsId, rolesId.filmsId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmsId, acteursId);
    }
}
