package by.guzypaul.medicinecentre.controller.command.impl;

import by.guzypaul.medicinecentre.controller.command.Command;
import by.guzypaul.medicinecentre.controller.command.CommandException;
import by.guzypaul.medicinecentre.controller.command.Router;
import by.guzypaul.medicinecentre.controller.util.PageFinder;

import javax.servlet.http.HttpServletRequest;

public class ChangeLanguageCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        String language = request.getParameter("language");

        if(language != null && !language.isEmpty() && Languages.isValidLanguage(language)) {
            request.getSession().setAttribute("locale", language);
            return new Router(PageFinder.findLastPage(request), Router.Type.REDIRECT);
        }

        throw new CommandException("Invalid Language");
    }
}
