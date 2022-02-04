package by.guzypaul.medicinecentre.controller.command.impl;

import by.guzypaul.medicinecentre.controller.command.Command;
import by.guzypaul.medicinecentre.controller.command.CommandException;
import by.guzypaul.medicinecentre.controller.command.Router;
import by.guzypaul.medicinecentre.entity.Appointment;
import by.guzypaul.medicinecentre.service.ServiceFactory;
import by.guzypaul.medicinecentre.service.exception.ServiceException;
import by.guzypaul.medicinecentre.service.AppointmentService;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * The type Delete appointment page command.
 * @author Guziy Paul
 * @see Command
 */
public class DeleteAppointmentPageCommand implements Command {
    private final AppointmentService appointmentService;

    /**
     * Instantiates a new Delete appointment page command.
     */
    public DeleteAppointmentPageCommand() {
        appointmentService = ServiceFactory.getInstance().getAppointmentService();
    }

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        try {
            String appointmentId = request.getParameter("appointmentId");
            Optional<Appointment> appointmentOptional = appointmentService.readById(appointmentId);

            if (appointmentOptional.isPresent()) {
                request.setAttribute("appointmentId", appointmentId);
                return new Router("/jsp/delete_appointment_page.jsp", Router.Type.FORWARD);
            }

            throw new CommandException("Invalid appointment");
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
    }
}
