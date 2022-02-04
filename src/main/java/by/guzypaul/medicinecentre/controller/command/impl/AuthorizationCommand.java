package by.guzypaul.medicinecentre.controller.command.impl;

import by.guzypaul.medicinecentre.controller.command.Command;
import by.guzypaul.medicinecentre.controller.command.CommandException;
import by.guzypaul.medicinecentre.controller.command.Router;
import by.guzypaul.medicinecentre.entity.User;
import by.guzypaul.medicinecentre.service.ServiceFactory;
import by.guzypaul.medicinecentre.service.exception.ServiceException;
import by.guzypaul.medicinecentre.service.UserService;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * The type Authorization command.
 * @author Guziy Paul
 * @see Command
 */
public class AuthorizationCommand implements Command {
    private final UserService userService;

    /**
     * Instantiates a new Authorization command.
     */
    public AuthorizationCommand() {
        userService = ServiceFactory.getInstance().getUserService();
    }

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        try {
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            if (email == null || email.isEmpty()
                    || password == null || password.isEmpty()) {
                request.getSession().setAttribute("isUserAuthorized", false);
                return new Router("/controller?command=authorization_page", Router.Type.REDIRECT);
            }

            Optional<User> userOptional = userService.readByEmail(email);
            if (userOptional.isPresent() && BCrypt.checkpw(password, userOptional.get().getPassword())) {
                request.getSession().setAttribute("userId", userOptional.get().getId());
                request.getSession().setAttribute("role", userOptional.get().getRole().toString());
                request.getSession().setAttribute("isUserAuthorized", true);
                return new Router("/controller?command=procedures", Router.Type.REDIRECT);
            } else {
                request.getSession().setAttribute("isUserAuthorized", false);
                return new Router("/controller?command=authorization_page", Router.Type.REDIRECT);
            }
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
    }
}
