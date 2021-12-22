package by.guzypaul.medicinecentre.service.interfaces;

import by.guzypaul.medicinecentre.entity.Entity;
import by.guzypaul.medicinecentre.service.exception.ServiceException;

import java.util.List;

public interface BaseService<T extends Entity> {
    List<T> readAll() throws ServiceException;

    T readById(String id) throws ServiceException;

    boolean deleteById(String id) throws ServiceException;

    boolean create(T entity) throws ServiceException;

    boolean update(T entity) throws ServiceException;
}
