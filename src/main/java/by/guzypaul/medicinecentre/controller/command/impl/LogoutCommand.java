package by.guzypaul.medicinecentre.controller.command.impl;

import by.guzypaul.medicinecentre.controller.command.Command;
import by.guzypaul.medicinecentre.controller.command.CommandException;
import by.guzypaul.medicinecentre.controller.command.Router;

import javax.servlet.http.HttpServletRequest;

/**
 * The type Logout command.
 * @author Guziy Paul
 * @see Command
 */
public class LogoutCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        request.getSession().setAttribute("isUserLogout", true);
        request.getSession().setAttribute("role", "GUEST");
        request.getSession().removeAttribute("userId");
        return new Router("/controller?command=procedures", Router.Type.REDIRECT);
    }
}
