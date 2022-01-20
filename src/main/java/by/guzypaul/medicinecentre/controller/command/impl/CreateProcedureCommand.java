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

public class CreateProcedureCommand implements Command {
    private final ProcedureService procedureService;

    public CreateProcedureCommand() {
        procedureService = ServiceFactory.getInstance().getProcedureService();
    }

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        try {
            String name = request.getParameter("name");
            String imageName = request.getParameter("imageName");
            String price = request.getParameter("price");
            String description = request.getParameter("description");
            String duration = request.getParameter("duration");
            String doctorQualification = request.getParameter("doctorQualification");

            if (name == null || name.isEmpty()
                    || imageName == null || imageName.isEmpty()
                    || price == null || price.isEmpty()
                    || description == null || description.isEmpty()
                    || duration == null || duration.isEmpty()
                    || doctorQualification == null || doctorQualification.isEmpty()) {
                return new Router("/controller?command=create_procedure_page", Router.Type.REDIRECT);
            }

            Procedure procedure = new Procedure(name, imageName, BigDecimal.valueOf(Double.parseDouble(price)),
                    description, Integer.parseInt(duration), doctorQualification);

            boolean isUserCreated = procedureService.create(procedure);

            if (isUserCreated) {
                return new Router("/controller?command=procedures", Router.Type.REDIRECT);
            } else {
                return new Router("/controller?command=create_procedure_page", Router.Type.REDIRECT);
            }
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
    }
}
