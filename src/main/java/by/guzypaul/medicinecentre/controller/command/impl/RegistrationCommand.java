package by.guzypaul.medicinecentre.controller.command.impl;

import by.guzypaul.medicinecentre.controller.command.Command;
import by.guzypaul.medicinecentre.controller.command.CommandException;
import by.guzypaul.medicinecentre.controller.command.Router;
import by.guzypaul.medicinecentre.entity.Role;
import by.guzypaul.medicinecentre.entity.User;
import by.guzypaul.medicinecentre.service.ServiceFactory;
import by.guzypaul.medicinecentre.service.exception.ServiceException;
import by.guzypaul.medicinecentre.service.interfaces.UserService;

import javax.servlet.http.HttpServletRequest;

/**
 * The type Registration command.
 * @author Guziy Paul
 * @see Command
 */
public class RegistrationCommand implements Command {
    private final UserService userService;

    /**
     * Instantiates a new Registration command.
     */
    public RegistrationCommand() {
        userService = ServiceFactory.getInstance().getUserService();
    }

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        try {
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String password = request.getParameter("password");

            if (name == null || name.isEmpty()
                    || surname == null || surname.isEmpty()
                    || email == null || email.isEmpty()
                    || phone == null || phone.isEmpty()
                    || password == null || password.isEmpty()) {
                request.getSession().setAttribute("isUserRegistered", false);
                return new Router("/controller?command=registration_page", Router.Type.REDIRECT);
            }

            User user = new User(name, surname, email, password, phone, Role.USER);

            boolean isUserRegistered = userService.create(user);

            if (isUserRegistered) {
                request.getSession().setAttribute("isUserRegistered", true);
                return new Router("/controller?command=authorization_page", Router.Type.REDIRECT);
            } else {
                request.getSession().setAttribute("isUserRegistered", false);
                return new Router("/controller?command=registration_page", Router.Type.REDIRECT);
            }
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
    }
}
