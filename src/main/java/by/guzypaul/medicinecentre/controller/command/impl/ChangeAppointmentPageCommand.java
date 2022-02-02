package by.guzypaul.medicinecentre.controller.command.impl;

import by.guzypaul.medicinecentre.controller.command.Command;
import by.guzypaul.medicinecentre.controller.command.CommandException;
import by.guzypaul.medicinecentre.controller.command.Router;
import by.guzypaul.medicinecentre.entity.Appointment;
import by.guzypaul.medicinecentre.entity.AppointmentStatus;
import by.guzypaul.medicinecentre.service.ServiceFactory;
import by.guzypaul.medicinecentre.service.exception.ServiceException;
import by.guzypaul.medicinecentre.service.interfaces.AppointmentService;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * The type Change appointment page command.
 * @author Guziy Paul
 * @see Command
 */
public class ChangeAppointmentPageCommand implements Command {
    private final AppointmentService appointmentService;

    /**
     * Instantiates a new Change appointment page command.
     */
    public ChangeAppointmentPageCommand() {
        appointmentService = ServiceFactory.getInstance().getAppointmentService();
    }

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        try {
            String appointmentId = request.getParameter("appointmentId");

            if (appointmentId == null) {
                appointmentId = request.getSession().getAttribute("appointmentId").toString();
                request.removeAttribute("appointmentId");
                if (appointmentId == null) {
                    throw new CommandException("Unknown appointment!");
                }
            }

            Optional<Appointment> optionalAppointment = appointmentService.readById(appointmentId);

            if (optionalAppointment.isPresent()) {
                request.setAttribute("appointment", optionalAppointment.get());
                request.setAttribute("statusList", AppointmentStatus.values());
                return new Router("/jsp/change_appointment.jsp", Router.Type.FORWARD);
            }

            throw new CommandException("Invalid appointment");
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
    }
}
