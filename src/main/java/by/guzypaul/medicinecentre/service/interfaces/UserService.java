package by.guzypaul.medicinecentre.service.interfaces;

import by.guzypaul.medicinecentre.entity.User;
import by.guzypaul.medicinecentre.service.exception.ServiceException;

import java.util.Optional;

public interface UserService extends BaseService<User> {
    Optional<User> readByEmail(String email) throws ServiceException;

    Optional<User> readByPhone(String phone) throws ServiceException;
}
