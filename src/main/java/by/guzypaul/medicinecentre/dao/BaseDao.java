package by.guzypaul.medicinecentre.dao;

import by.guzypaul.medicinecentre.entity.Entity;

import java.util.List;

public interface BaseDao <K, T extends Entity> {
    List<T> readAll() throws DaoException;
    T readById(K id) throws DaoException;
    boolean deleteById(K id) throws DaoException;
    boolean create(T entity) throws DaoException;
    boolean update(T entity) throws DaoException;
}
