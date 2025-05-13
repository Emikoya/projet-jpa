package fr.diginamic.dao;

import fr.diginamic.dto.FilmsDto;
import fr.diginamic.entities.Films;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

/**
 * Mise en place d'une interface commune pour chaque DAO.
 */

public interface InterfaceDao<T> {
    T extraire(T entity) throws SQLException;
    void insert(T entity);
}
