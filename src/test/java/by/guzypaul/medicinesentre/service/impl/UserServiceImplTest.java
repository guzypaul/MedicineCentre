package by.guzypaul.medicinesentre.service.impl;

import by.guzypaul.medicinecentre.dao.DaoException;
import by.guzypaul.medicinecentre.dao.UserDao;
import by.guzypaul.medicinecentre.entity.Role;
import by.guzypaul.medicinecentre.entity.User;
import by.guzypaul.medicinecentre.service.checker.UserCreatingDuplicationChecker;
import by.guzypaul.medicinecentre.service.checker.UserUpdatingDuplicationChecker;
import by.guzypaul.medicinecentre.service.exception.ServiceException;
import by.guzypaul.medicinecentre.service.impl.UserServiceImpl;
import by.guzypaul.medicinecentre.service.validator.UserValidator;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceImplTest {
    private UserServiceImpl userService;
    private UserDao userDao;
    private User firstTestUser;
    private User secondTestUser;
    private UserCreatingDuplicationChecker userCreatingDuplicationChecker;
    private UserUpdatingDuplicationChecker userUpdatingDuplicationChecker;
    private UserValidator userValidator;

    @BeforeEach
    void setUp() {
        userService = new UserServiceImpl();
        userDao = mock(UserDao.class);
        userValidator = mock(UserValidator.class);
        userCreatingDuplicationChecker = mock(UserCreatingDuplicationChecker.class);
        userUpdatingDuplicationChecker = mock(UserUpdatingDuplicationChecker.class);
        userService.setUserDao(userDao);
        userService.setUserValidator(userValidator);
        userService.setUserCreatingDuplicationChecker(userCreatingDuplicationChecker);
        userService.setUserUpdatingDuplicationChecker(userUpdatingDuplicationChecker);

        firstTestUser = new User(1, "Dmitriy", "Kruglov", "kruglov@gmail.com",
                "123456", "+37525123456", Role.USER);
        secondTestUser = new User(2, "Vladislav", "Romanovskiy", "romavlad@gmail.com",
                "12345678", "+37525123666", Role.USER);
    }

    @Test
    void readAllUsersTest() throws DaoException, ServiceException {
        List<User> userList = Arrays.asList(firstTestUser, secondTestUser);
        when(userDao.readAll()).thenReturn(userList);
        Assert.assertEquals(userList, userService.readAll());
    }

    @Test
    void readUsersByIdTest() throws DaoException, ServiceException {
        when(userDao.readById(1)).thenReturn(Optional.of(firstTestUser));
        Assert.assertEquals(firstTestUser, userService.readById("1").get());
    }

    @Test
    void readUserWithInvalidIdTest() {
        Assert.assertThrows(NumberFormatException.class, () -> userService.readById("egeg"));
    }

    @Test
    void addUserTest() throws DaoException, ServiceException {
        when(userDao.create(firstTestUser)).thenReturn(true);
        when(userValidator.validateUser(firstTestUser)).thenReturn(true);
        when(userCreatingDuplicationChecker.checkDuplication(firstTestUser)).thenReturn(true);
        Assert.assertTrue(userService.create(firstTestUser));
    }

    @Test
    void deleteUserByIdTest() throws DaoException, ServiceException {
        when(userDao.deleteById(1)).thenReturn(true);
        Assert.assertTrue(userService.deleteById("1"));
    }

    @Test
    void deleteUserWithInvalidIdTest() {
        Assert.assertThrows(NumberFormatException.class, () -> userService.deleteById("dada"));
    }

    @Test
    void updateUserTest() throws DaoException, ServiceException {
        when(userValidator.validateUserForUpdating(firstTestUser)).thenReturn(true);
        when(userUpdatingDuplicationChecker.checkDuplication(firstTestUser)).thenReturn(true);
        when(userDao.update(firstTestUser)).thenReturn(true);
        Assert.assertTrue(userService.update(firstTestUser));
    }

    @Test
    void readUserByEmailTest() throws DaoException, ServiceException {
        when(userDao.readByEmail("kruglov@gmail.com")).thenReturn(Optional.of(firstTestUser));
        Assert.assertEquals(Optional.of(firstTestUser), userService.readByEmail("kruglov@gmail.com"));
    }

    @Test
    void readUserByPhoneTest() throws DaoException, ServiceException {
        when(userDao.readByPhone("+37525123456")).thenReturn(Optional.of(firstTestUser));
        Assert.assertEquals(Optional.of(firstTestUser), userService.readByPhone("+37525123456"));
    }
}
