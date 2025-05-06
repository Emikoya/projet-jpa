package fr.diginamic.entities;

import fr.diginamic.entities.base.Personnes;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Définit un acteur. Il prend pour héritage les attributs de la classe Personnes
 */
@Entity
@Table(name="acteurs")
public class Acteurs extends Personnes {

    private double taille;

    public Acteurs() {
    }

    /**
     * @return taille
     */
    public double getTaille() {
        return taille;
    }
    /**
     * @param taille
     */
    public void setTaille(double taille) {
        this.taille = taille;
    }
}
