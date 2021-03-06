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
import java.util.Optional;

/**
 * The type Change user page command.
 */
public class ChangeUserPageCommand implements Command {
    private final UserService userService;

    /**
     * Instantiates a new Change user page command.
     * @author Guziy Paul
     * @see Command
     */
    public ChangeUserPageCommand() {
        userService = ServiceFactory.getInstance().getUserService();
    }

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        try {
            String userId = request.getParameter("userId");

            if (userId == null) {
                userId = request.getSession().getAttribute("updatingUserId").toString();
                request.getSession().removeAttribute("updatingUserId");
                if (userId == null) {
                    throw new CommandException("Unknown user!");
                }
            }

            Optional<User> userOptional = userService.readById(userId);

            if (userOptional.isPresent()) {
                request.setAttribute("user", userOptional.get());
                request.setAttribute("roleList", Role.values());

                return new Router("/jsp/change_user_page.jsp", Router.Type.FORWARD);
            }

            throw new CommandException("Invalid user");
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
    }
}
