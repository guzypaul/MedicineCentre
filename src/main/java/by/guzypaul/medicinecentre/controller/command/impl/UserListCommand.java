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
import java.util.List;
import java.util.stream.Collectors;

/**
 * The type User list command.
 * @author Guziy Paul
 * @see Command
 */
public class UserListCommand implements Command {
    private final UserService userService;

    /**
     * Instantiates a new User list command.
     */
    public UserListCommand() {
        userService = ServiceFactory.getInstance().getUserService();
    }

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        try {
            List<User> userList = userService.readAll();
            if (Role.valueOf(request.getSession().getAttribute("role").toString()) == Role.MODERATOR) {
                request.setAttribute("userList", userList.stream()
                        .filter(user -> user.getRole() == Role.USER)
                        .collect(Collectors.toList()));
            } else {
                request.setAttribute("userList", userList);
            }

            return new Router("/jsp/users.jsp", Router.Type.FORWARD);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
    }
}
