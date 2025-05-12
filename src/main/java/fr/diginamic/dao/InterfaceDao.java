package fr.diginamic.dao;

import java.sql.SQLException;
import java.util.List;

/**
 * Mise en place d'une interface commune pour chaque DAO.
 */

public interface InterfaceDao<T> {
    T extraire(T entity) throws SQLException;
    void insert(T entity);
}
