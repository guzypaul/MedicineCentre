package by.guzypaul.medicinecentre.dao.interfaces;

import by.guzypaul.medicinecentre.dao.DaoException;
import by.guzypaul.medicinecentre.entity.Entity;

import java.util.List;
import java.util.Optional;

public interface BaseDao <K, T extends Entity> {
    List<T> readAll() throws DaoException;
    Optional<T> readById(K id) throws DaoException;
    boolean deleteById(K id) throws DaoException;
    boolean create(T entity) throws DaoException;
    boolean update(T entity) throws DaoException;
}
