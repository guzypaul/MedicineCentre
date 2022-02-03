package by.guzypaul.medicinecentre.controller.command.impl;

import by.guzypaul.medicinecentre.controller.command.Command;
import by.guzypaul.medicinecentre.controller.command.CommandException;
import by.guzypaul.medicinecentre.controller.command.Router;
import by.guzypaul.medicinecentre.entity.Procedure;
import by.guzypaul.medicinecentre.entity.Qualification;
import by.guzypaul.medicinecentre.service.ServiceFactory;
import by.guzypaul.medicinecentre.service.exception.ServiceException;
import by.guzypaul.medicinecentre.service.interfaces.ProcedureService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.stream.Collectors;

/**
 * The type Create procedure command.
 * @author Guziy Paul
 * @see Command
 */
public class CreateProcedureCommand implements Command {
    private final ProcedureService procedureService;

    /**
     * Instantiates a new Create procedure command.
     */
    public CreateProcedureCommand() {
        procedureService = ServiceFactory.getInstance().getProcedureService();
    }

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        try {
            String name = request.getParameter("name");
            String price = request.getParameter("price");
            String description = request.getParameter("description");
            String duration = request.getParameter("duration");
            String doctorQualification = request.getParameter("doctorQualification");

            if (name == null || name.isEmpty()
                    || price == null || price.isEmpty()
                    || description == null || description.isEmpty()
                    || duration == null || duration.isEmpty()
                    || doctorQualification == null || doctorQualification.isEmpty()) {
                request.getSession().setAttribute("isProcedureCreated", false);

                return new Router("/controller?command=create_procedure_page", Router.Type.REDIRECT);
            }

            Procedure procedure = new Procedure(name, BigDecimal.valueOf(Double.parseDouble(price)),
                    description, Integer.parseInt(duration), Qualification.findByName(doctorQualification));

            for (Part part : request.getParts()) {
                if (part.getName().equals("procedure-picture")) {
                    InputStream inputStream = part.getInputStream();
                    InputStreamReader isr = new InputStreamReader(inputStream);
                    new BufferedReader(isr)
                            .lines()
                            .collect(Collectors.joining("\n"));
                    if (!part.getSubmittedFileName().isEmpty()) {
                        String pictureName = "procedure_" + procedure.getName() + "_" + part.getSubmittedFileName();
                        procedure.setImageName(pictureName);
                        part.write(pictureName);
                    }
                }
            }

            boolean isUserCreated = procedureService.create(procedure);

            if (isUserCreated) {
                request.getSession().setAttribute("isProcedureCreated", true);

                return new Router("/controller?command=procedures", Router.Type.REDIRECT);
            } else {
                request.getSession().setAttribute("isProcedureCreated", false);

                return new Router("/controller?command=create_procedure_page", Router.Type.REDIRECT);
            }
        } catch (ServiceException | IOException | ServletException e) {
            throw new CommandException(e);
        }
    }
}
