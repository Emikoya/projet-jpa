package fr.diginamic.entities.embedded;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CastingPrincipalId implements Serializable {
    private String filmsId;
    private int acteursId;

    public CastingPrincipalId() {
    }

    public CastingPrincipalId(String filmsId, int acteursId) {
        this.filmsId = filmsId;
        this.acteursId = acteursId;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        CastingPrincipalId that = (CastingPrincipalId) object;
        return acteursId == that.acteursId && Objects.equals(filmsId, that.filmsId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmsId, acteursId);
    }
}
