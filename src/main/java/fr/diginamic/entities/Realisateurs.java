package fr.diginamic.entities;

import fr.diginamic.entities.base.Personnes;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Définit un réalisateur en entité. Il prend pour héritage les attributs de la classe Personnes
 */
@Entity
@Table(name="realisateurs")
public class Realisateurs extends Personnes {
    public Realisateurs() {
    }
}
