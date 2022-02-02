package by.guzypaul.medicinecentre.dao.interfaces;

import by.guzypaul.medicinecentre.dao.DaoException;
import by.guzypaul.medicinecentre.entity.Entity;

import java.util.List;
import java.util.Optional;

/**
 * The interface Base dao.
 *
 * @param <K> the type parameter
 * @param <T> the type parameter
 */
public interface BaseDao <K, T extends Entity> {
    /**
     * Read all list.
     *
     * @return the list
     * @throws DaoException the dao exception
     */
    List<T> readAll() throws DaoException;

    /**
     * Read by id optional.
     *
     * @param id the id
     * @return the optional
     * @throws DaoException the dao exception
     */
    Optional<T> readById(K id) throws DaoException;

    /**
     * Delete by id boolean.
     *
     * @param id the id
     * @return the boolean
     * @throws DaoException the dao exception
     */
    boolean deleteById(K id) throws DaoException;

    /**
     * Create boolean.
     *
     * @param entity the entity
     * @return the boolean
     * @throws DaoException the dao exception
     */
    boolean create(T entity) throws DaoException;

    /**
     * Update boolean.
     *
     * @param entity the entity
     * @return the boolean
     * @throws DaoException the dao exception
     */
    boolean update(T entity) throws DaoException;
}
