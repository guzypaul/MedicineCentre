package by.guzypaul.medicinecentre.dao;

import by.guzypaul.medicinecentre.entity.Entity;

import java.util.List;

public interface BaseDao <K, T extends Entity> {
    List<T> readAll();
    T readById(K id) throws DaoException;
    boolean deleteById(K id);
    boolean create(T entity);
    boolean update(T entity);
}
