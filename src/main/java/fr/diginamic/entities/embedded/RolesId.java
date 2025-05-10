package fr.diginamic.entities.embedded;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * Définit une classe composée afin d'établir le lien entre les clés étrangères
 */

@Embeddable
public class RolesId implements Serializable {
    private String filmsId;
    private int acteursId;

    public RolesId() {
    }

    public RolesId(String filmsId, int acteursId) {
        this.filmsId = filmsId;
        this.acteursId = acteursId;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        RolesId rolesId = (RolesId) object;
        return acteursId == rolesId.acteursId && Objects.equals(filmsId, rolesId.filmsId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmsId, acteursId);
    }
}
