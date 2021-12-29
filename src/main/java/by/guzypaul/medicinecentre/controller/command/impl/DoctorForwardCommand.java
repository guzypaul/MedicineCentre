package by.guzypaul.medicinecentre.controller.command.impl;

import by.guzypaul.medicinecentre.controller.command.Command;
import by.guzypaul.medicinecentre.controller.command.CommandException;
import by.guzypaul.medicinecentre.controller.command.Router;
import by.guzypaul.medicinecentre.service.ServiceFactory;
import by.guzypaul.medicinecentre.service.exception.ServiceException;
import by.guzypaul.medicinecentre.service.interfaces.DoctorService;

import javax.servlet.http.HttpServletRequest;

public class DoctorForwardCommand implements Command {
    private final DoctorService doctorService;

    public DoctorForwardCommand() {
        doctorService = ServiceFactory.getInstance().getDoctorService();
    }

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        try {
            request.setAttribute("doctor", doctorService.readById(request.getParameter("doctorId")).get()); //todo check isPresent
            return new Router("/jsp/doctor_page.jsp", Router.Type.FORWARD);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
    }
}
