package by.guzypaul.medicinecentre.controller.command.impl;

import by.guzypaul.medicinecentre.controller.command.Command;
import by.guzypaul.medicinecentre.controller.command.CommandException;
import by.guzypaul.medicinecentre.controller.command.Router;
import by.guzypaul.medicinecentre.entity.Qualification;

import javax.servlet.http.HttpServletRequest;

public class CreateProcedurePageCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        request.setAttribute("qualificationList", Qualification.values());
        return new Router("/jsp/create_procedure_page.jsp", Router.Type.FORWARD);
    }
}
