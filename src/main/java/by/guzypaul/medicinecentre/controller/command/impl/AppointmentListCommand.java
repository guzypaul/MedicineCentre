package by.guzypaul.medicinecentre.controller.command.impl;

import by.guzypaul.medicinecentre.controller.command.Command;
import by.guzypaul.medicinecentre.controller.command.CommandException;
import by.guzypaul.medicinecentre.controller.command.Router;
import by.guzypaul.medicinecentre.entity.Appointment;
import by.guzypaul.medicinecentre.entity.Doctor;
import by.guzypaul.medicinecentre.service.ServiceFactory;
import by.guzypaul.medicinecentre.service.exception.ServiceException;
import by.guzypaul.medicinecentre.service.AppointmentService;
import by.guzypaul.medicinecentre.service.DoctorService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

/**
 * The type Appointment list command.
 * @author Guziy Paul
 * @see Command
 */
public class AppointmentListCommand implements Command {
    private final DoctorService doctorService;
    private final AppointmentService appointmentService;

    /**
     * Instantiates a new Appointment list command.
     */
    public AppointmentListCommand() {
        doctorService = ServiceFactory.getInstance().getDoctorService();
        appointmentService = ServiceFactory.getInstance().getAppointmentService();
    }

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        try {
            String role = String.valueOf(request.getSession().getAttribute("role"));
            String userId = request.getSession().getAttribute("userId").toString();

            if (role.toUpperCase() == "DOCTOR") {
                Optional<Doctor> doctorOptional = doctorService.readByUserId(userId);
                String doctorId = String.valueOf(doctorOptional.get().getId());
                List<Appointment> appointmentListForDoctor = appointmentService.readByDoctorId(doctorId);
                request.setAttribute("appointmentList", appointmentListForDoctor);
            } else if (role.toUpperCase() == "USER") {
                List<Appointment> appointmentListForClient = appointmentService.readByClientId(userId);
                request.setAttribute("appointmentList", appointmentListForClient);
            } else if (role.toUpperCase() == "MODERATOR" || role.toUpperCase() == "ADMIN") {
                List<Appointment> appointmentList = appointmentService.readAll();
                request.setAttribute("appointmentList", appointmentList);
            }

            return new Router("/jsp/appointments.jsp", Router.Type.FORWARD);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
    }
}
