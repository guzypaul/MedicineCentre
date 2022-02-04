package by.guzypaul.medicinecentre.controller.command.impl;

import by.guzypaul.medicinecentre.controller.command.Command;
import by.guzypaul.medicinecentre.controller.command.CommandException;
import by.guzypaul.medicinecentre.controller.command.Router;
import by.guzypaul.medicinecentre.service.ServiceFactory;
import by.guzypaul.medicinecentre.service.exception.ServiceException;
import by.guzypaul.medicinecentre.service.ProcedureService;

import javax.servlet.http.HttpServletRequest;

/**
 * The type Procedure list forward command.
 * @author Guziy Paul
 * @see Command
 */
public class ProcedureListForwardCommand implements Command {
    private final ProcedureService procedureService;

    /**
     * Instantiates a new Procedure list forward command.
     */
    public ProcedureListForwardCommand() {
        procedureService = ServiceFactory.getInstance().getProcedureService();
    }

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        try {
            request.setAttribute("procedureList", procedureService.readAll());
            return new Router("/jsp/procedures.jsp", Router.Type.FORWARD);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
    }
}
