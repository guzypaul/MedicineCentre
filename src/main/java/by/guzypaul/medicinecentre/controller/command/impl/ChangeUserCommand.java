package by.guzypaul.medicinecentre.controller.command.impl;

import by.guzypaul.medicinecentre.controller.command.Command;
import by.guzypaul.medicinecentre.controller.command.CommandException;
import by.guzypaul.medicinecentre.controller.command.Router;
import by.guzypaul.medicinecentre.entity.Role;
import by.guzypaul.medicinecentre.entity.User;
import by.guzypaul.medicinecentre.service.ServiceFactory;
import by.guzypaul.medicinecentre.service.exception.ServiceException;
import by.guzypaul.medicinecentre.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;
import java.util.Optional;

/**
 * The type Change user command.
 *
 * @author Guziy Paul
 * @see Command
 */
public class ChangeUserCommand implements Command {
    private final UserService userService;

    /**
     * Instantiates a new Change user command.
     */
    public ChangeUserCommand() {
        userService = ServiceFactory.getInstance().getUserService();
    }

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        try {
            String userId = request.getParameter("userId");
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String role = request.getParameter("role");

            if (userId == null || userId.isEmpty()
                    || name == null || name.isEmpty()
                    || surname == null || surname.isEmpty()
                    || email == null || email.isEmpty()
                    || phone == null || phone.isEmpty()
                    || role == null || role.isEmpty()) {
                request.getSession().setAttribute("isUserChanged", false);
                request.getSession().setAttribute("userId", userId);

                return new Router("/controller?command=change_user_page", Router.Type.REDIRECT);
            }

            String currentRole = request.getSession().getAttribute("role").toString();
            String currentId = request.getSession().getAttribute("userId").toString();

            if (Objects.equals(currentRole, "USER") && (!userId.equals(currentId) || !role.equals(currentRole))) {
                throw new CommandException("Attempted Unauthorized Access!");
            }

            Optional<User> userOptional = userService.readById(userId);

            if (userOptional.isPresent()) {
                User user = new User(Integer.parseInt(userId), name, surname, email, phone, Role.valueOf(role));

                userService.update(user);

                if (request.getSession().getAttribute("role").equals("USER")) {
                    request.getSession().setAttribute("isUserChanged", true);

                    return new Router("/controller?command=profile_page", Router.Type.REDIRECT);
                }
                request.getSession().setAttribute("isUserChanged", true);

                return new Router("/controller?command=users", Router.Type.REDIRECT);
            } else {
                request.getSession().setAttribute("isUserChanged", false);
                return new Router("/controller?command=change_user_page", Router.Type.REDIRECT);
            }
        } catch (ServiceException e) {
            throw new CommandException(e.getMessage());
        }
    }
}
