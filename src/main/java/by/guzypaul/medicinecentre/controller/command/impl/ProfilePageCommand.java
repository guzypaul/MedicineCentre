package by.guzypaul.medicinecentre.controller.command.impl;

import by.guzypaul.medicinecentre.controller.command.Command;
import by.guzypaul.medicinecentre.controller.command.CommandException;
import by.guzypaul.medicinecentre.controller.command.Router;
import by.guzypaul.medicinecentre.entity.User;
import by.guzypaul.medicinecentre.service.ServiceFactory;
import by.guzypaul.medicinecentre.service.exception.ServiceException;
import by.guzypaul.medicinecentre.service.interfaces.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class ProfilePageCommand implements Command {
    private final UserService userService;

    public ProfilePageCommand() {
        userService = ServiceFactory.getInstance().getUserService();
    }

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        try {
            String userId = request.getSession().getAttribute("userId").toString();
            Optional<User> userOptional = userService.readById(userId);
            if(userOptional.isPresent()){
                request.setAttribute("user", userOptional.get());
                return new Router("/jsp/profile_page.jsp", Router.Type.FORWARD);
            }

            throw new CommandException("Invalid user");
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
    }
}
