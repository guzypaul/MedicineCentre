package by.guzypaul.medicinecentre.controller.command.impl;

import by.guzypaul.medicinecentre.controller.command.Command;
import by.guzypaul.medicinecentre.controller.command.CommandException;
import by.guzypaul.medicinecentre.controller.command.Router;
import by.guzypaul.medicinecentre.entity.Procedure;
import by.guzypaul.medicinecentre.entity.Qualification;
import by.guzypaul.medicinecentre.service.ServiceFactory;
import by.guzypaul.medicinecentre.service.exception.ServiceException;
import by.guzypaul.medicinecentre.service.interfaces.ProcedureService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ChangeProcedurePageCommand implements Command {
    private final ProcedureService procedureService;

    public ChangeProcedurePageCommand() {
        procedureService = ServiceFactory.getInstance().getProcedureService();
    }

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        try {
            String procedureId = request.getParameter("procedureId");
            Optional<Procedure> procedureOptional = procedureService.readById(procedureId);

            if  (procedureOptional.isPresent()) {
                request.setAttribute("procedure", procedureOptional.get());

                List<String> qualificationList = new ArrayList<>();
                for (Qualification qualification : Qualification.values()) {
                    String qualificationName = qualification.getQualificationName();
                    qualificationList.add(qualificationName);
                }

                request.setAttribute("qualificationList", qualificationList);
                return new Router("/jsp/change_procedure_page.jsp", Router.Type.FORWARD);
            }

            throw new CommandException("Invalid procedure!");
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
    }
}
