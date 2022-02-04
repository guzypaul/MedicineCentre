package by.guzypaul.medicinecentre.controller.command.impl;

import by.guzypaul.medicinecentre.controller.command.Command;
import by.guzypaul.medicinecentre.controller.command.CommandException;
import by.guzypaul.medicinecentre.controller.command.Router;
import by.guzypaul.medicinecentre.service.ServiceFactory;
import by.guzypaul.medicinecentre.service.exception.ServiceException;
import by.guzypaul.medicinecentre.service.DoctorService;

import javax.servlet.http.HttpServletRequest;

/**
 * The type Doctor list forward command.
 * @author Guziy Paul
 * @see Command
 */
public class DoctorListForwardCommand implements Command {
    private final DoctorService doctorService;

    /**
     * Instantiates a new Doctor list forward command.
     */
    public DoctorListForwardCommand() {
        doctorService = ServiceFactory.getInstance().getDoctorService();
    }

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        try {
            request.setAttribute("doctorList", doctorService.readAll());
            return new Router("/jsp/doctors.jsp", Router.Type.FORWARD);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
    }
}
