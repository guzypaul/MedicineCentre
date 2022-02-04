package by.guzypaul.medicinecentre.service;

import by.guzypaul.medicinecentre.entity.Entity;
import by.guzypaul.medicinecentre.service.exception.ServiceException;

import java.util.List;
import java.util.Optional;

/**
 * The interface Base service.
 * @author Guziy Paul
 *
 * @param <T> the type parameter
 */
public interface BaseService<T extends Entity> {
    /**
     * Read all list.
     *
     * @return the list
     * @throws ServiceException the service exception
     */
    List<T> readAll() throws ServiceException;

    /**
     * Read by id optional.
     *
     * @param id the id
     * @return the optional
     * @throws ServiceException the service exception
     */
    Optional<T> readById(String id) throws ServiceException;

    /**
     * Delete by id boolean.
     *
     * @param id the id
     * @return the boolean
     * @throws ServiceException the service exception
     */
    boolean deleteById(String id) throws ServiceException;

    /**
     * Create boolean.
     *
     * @param entity the entity
     * @return the boolean
     * @throws ServiceException the service exception
     */
    boolean create(T entity) throws ServiceException;

    /**
     * Update boolean.
     *
     * @param entity the entity
     * @return the boolean
     * @throws ServiceException the service exception
     */
    boolean update(T entity) throws ServiceException;
}
