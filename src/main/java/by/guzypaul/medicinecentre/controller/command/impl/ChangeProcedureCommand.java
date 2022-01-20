package by.guzypaul.medicinecentre.controller.command.impl;

import by.guzypaul.medicinecentre.controller.command.Command;
import by.guzypaul.medicinecentre.controller.command.CommandException;
import by.guzypaul.medicinecentre.controller.command.Router;
import by.guzypaul.medicinecentre.entity.Procedure;
import by.guzypaul.medicinecentre.service.ServiceFactory;
import by.guzypaul.medicinecentre.service.exception.ServiceException;
import by.guzypaul.medicinecentre.service.interfaces.ProcedureService;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Optional;

public class ChangeProcedureCommand implements Command {
    private final ProcedureService procedureService;

    public ChangeProcedureCommand() {
        procedureService = ServiceFactory.getInstance().getProcedureService();
    }

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        try {
            String procedureId = request.getParameter("procedureId");
            String name = request.getParameter("name");
            String imageName = request.getParameter("imageName");
            String price = request.getParameter("price");
            String description = request.getParameter("description");
            String duration = request.getParameter("duration");

            if (procedureId == null || procedureId.isEmpty()
                    || name == null || name.isEmpty()
                    || imageName == null || imageName.isEmpty()
                    || price == null || price.isEmpty()
                    || description == null || description.isEmpty()
                    || duration == null || duration.isEmpty()) {
                return new Router("/controller?command=change_procedure_page", Router.Type.REDIRECT);
            }

            Optional<Procedure> procedureOptional = procedureService.readById(procedureId);

            if (procedureOptional.isPresent()) {
                Procedure procedure = new Procedure(Integer.parseInt(procedureId), name, imageName,
                        BigDecimal.valueOf(Double.parseDouble(price)), description, Integer.parseInt(duration));
                procedureService.update(procedure);

                return new Router("/controller?command=procedure_page&procedureId=" + procedureId, Router.Type.REDIRECT);
            } else {
                return new Router("/controller?command=change_procedure_page", Router.Type.REDIRECT);
            }

        } catch (ServiceException e) {
            throw new CommandException(e);
        }
    }
}
