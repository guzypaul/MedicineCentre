package by.guzypaul.medicinecentre.controller.command.impl;

import by.guzypaul.medicinecentre.controller.command.Command;
import by.guzypaul.medicinecentre.controller.command.CommandException;
import by.guzypaul.medicinecentre.controller.command.Router;
import by.guzypaul.medicinecentre.entity.Procedure;
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
import java.util.Optional;
import java.util.stream.Collectors;

public class ChangeProcedureCommand implements Command {
    private final ProcedureService procedureService;

    public ChangeProcedureCommand() {
        procedureService = ServiceFactory.getInstance().getProcedureService();
    }

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        try {
            String procedureId = request.getParameter("procedureId");
            String currentImageName = request.getParameter("currentImageName");
            String name = request.getParameter("name");
            String price = request.getParameter("price");
            String description = request.getParameter("description");
            String duration = request.getParameter("duration");
            String doctorQualification = request.getParameter("doctorQualification");

            if (procedureId == null || procedureId.isEmpty()
                    || currentImageName == null || currentImageName.isEmpty()
                    || name == null || name.isEmpty()
                    || price == null || price.isEmpty()
                    || description == null || description.isEmpty()
                    || duration == null || duration.isEmpty()
                    || doctorQualification == null || doctorQualification.isEmpty()) {
                request.getSession().setAttribute("isProcedureChanged", false);
                request.getSession().setAttribute("procedureId", procedureId);

                return new Router("/controller?command=change_procedure_page", Router.Type.REDIRECT);
            }

            Optional<Procedure> procedureOptional = procedureService.readById(procedureId);

            if (procedureOptional.isPresent()) {
                Procedure procedure = new Procedure(Integer.parseInt(procedureId), name,
                        BigDecimal.valueOf(Double.parseDouble(price)), description, Integer.parseInt(duration),
                        doctorQualification);

                for (Part part : request.getParts()) {
                    if (part.getName().equals("procedure-picture")) {
                        InputStream inputStream = part.getInputStream();
                        InputStreamReader isr = new InputStreamReader(inputStream);
                        new BufferedReader(isr)
                                .lines()
                                .collect(Collectors.joining("\n"));
                        if (!part.getSubmittedFileName().isEmpty()
                                && ("procedure_" + procedure.getName() + "_" + part.getSubmittedFileName()) != currentImageName) {
                            String pictureName = "procedure_" + procedure.getName() + "_" + part.getSubmittedFileName();
                            procedure.setImageName(pictureName);
                            part.write(pictureName);
                        } else {
                            procedure.setImageName(currentImageName);
                        }
                    }
                }

                boolean isProcedureUpdate = procedureService.update(procedure);
                if (isProcedureUpdate) {
                    request.getSession().setAttribute("isProcedureChanged", true);
                    return new Router("/controller?command=procedure_page&procedureId=" + procedureId, Router.Type.REDIRECT);
                } else {
                    request.getSession().setAttribute("isProcedureChanged", false);
                    return new Router("/controller?command=change_procedure_page", Router.Type.REDIRECT);
                }
            }
            throw new CommandException("Invalid data!");
        } catch (ServiceException | IOException | ServletException e) {
            throw new CommandException(e);
        }
    }
}
