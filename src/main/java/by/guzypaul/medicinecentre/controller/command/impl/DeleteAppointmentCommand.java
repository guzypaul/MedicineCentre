package by.guzypaul.medicinecentre.controller.command.impl;

import by.guzypaul.medicinecentre.controller.command.Command;
import by.guzypaul.medicinecentre.controller.command.CommandException;
import by.guzypaul.medicinecentre.controller.command.Router;
import by.guzypaul.medicinecentre.entity.Appointment;
import by.guzypaul.medicinecentre.service.ServiceFactory;
import by.guzypaul.medicinecentre.service.exception.ServiceException;
import by.guzypaul.medicinecentre.service.interfaces.AppointmentService;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class DeleteAppointmentCommand implements Command {
    private final AppointmentService appointmentService;

    public DeleteAppointmentCommand() {
        appointmentService = ServiceFactory.getInstance().getAppointmentService();
    }

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        try {
            String appointmentId = request.getParameter("appointmentId");
            Optional<Appointment> optionalAppointment = appointmentService.readById(appointmentId);
            if (optionalAppointment.isPresent()) {
                appointmentService.deleteById(appointmentId);
                return new Router("/jsp/appointments.jsp", Router.Type.REDIRECT);
            }

            throw new CommandException("Invalid appointment");
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
    }
}