package by.guzypaul.medicinecentre.controller.command.impl;

import by.guzypaul.medicinecentre.controller.command.Command;
import by.guzypaul.medicinecentre.controller.command.CommandException;
import by.guzypaul.medicinecentre.controller.command.Router;
import by.guzypaul.medicinecentre.service.ServiceFactory;
import by.guzypaul.medicinecentre.service.interfaces.AppointmentService;

import javax.servlet.http.HttpServletRequest;

public class AppointmentListForDoctorCommand implements Command {
    private final AppointmentService appointmentService;

    public AppointmentListForDoctorCommand() {
        appointmentService = ServiceFactory.getInstance().getAppointmentService();
    }

    @Override
    public Router execute(HttpServletRequest request) throws CommandException { //todo кинуть ProfilePageCommand
        /*try {
            request.setAttribute("appointmentListForDoctor", appointmentService.readByDoctorId());
            return new Router("/jsp/             .jsp", Router.Type.FORWARD);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }*/
        return null;
    }
}
