package by.guzypaul.medicinecentre.controller.command.impl;

import by.guzypaul.medicinecentre.controller.command.Command;
import by.guzypaul.medicinecentre.controller.command.CommandException;
import by.guzypaul.medicinecentre.controller.command.Router;
import by.guzypaul.medicinecentre.entity.Procedure;
import by.guzypaul.medicinecentre.service.ServiceFactory;
import by.guzypaul.medicinecentre.service.exception.ServiceException;
import by.guzypaul.medicinecentre.service.interfaces.ProcedureService;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class CreateAppointmentPageCommand implements Command {
    private final ProcedureService procedureService;

    public CreateAppointmentPageCommand() {
        procedureService = ServiceFactory.getInstance().getProcedureService();
    }

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        try {
            String procedureId = request.getParameter("procedureId");
            Optional<Procedure> procedureOptional = procedureService.readById(procedureId);

            if  (procedureOptional.isPresent()) {
                request.setAttribute("procedureId", procedureId);
                return new Router("/jsp/create_appointment_page.jsp", Router.Type.FORWARD);
            }

            throw new CommandException("Invalid procedure!");
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
    }
}
