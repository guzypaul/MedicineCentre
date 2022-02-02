package by.guzypaul.medicinecentre.service.interfaces;

import by.guzypaul.medicinecentre.entity.User;
import by.guzypaul.medicinecentre.service.exception.ServiceException;

import java.util.Optional;

/**
 * The interface User service.
 * @author Guziy Paul
 */
public interface UserService extends BaseService<User> {
    /**
     * Read by email optional.
     *
     * @param email the email
     * @return the optional
     * @throws ServiceException the service exception
     */
    Optional<User> readByEmail(String email) throws ServiceException;

    /**
     * Read by phone optional.
     *
     * @param phone the phone
     * @return the optional
     * @throws ServiceException the service exception
     */
    Optional<User> readByPhone(String phone) throws ServiceException;
}
