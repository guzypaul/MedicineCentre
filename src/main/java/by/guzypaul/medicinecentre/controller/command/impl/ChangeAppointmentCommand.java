package by.guzypaul.medicinecentre.controller.command.impl;

import by.guzypaul.medicinecentre.controller.command.Command;
import by.guzypaul.medicinecentre.controller.command.CommandException;
import by.guzypaul.medicinecentre.controller.command.Router;
import by.guzypaul.medicinecentre.entity.Appointment;
import by.guzypaul.medicinecentre.entity.Doctor;
import by.guzypaul.medicinecentre.entity.Procedure;
import by.guzypaul.medicinecentre.entity.User;
import by.guzypaul.medicinecentre.service.ServiceFactory;
import by.guzypaul.medicinecentre.service.exception.ServiceException;
import by.guzypaul.medicinecentre.service.interfaces.AppointmentService;
import by.guzypaul.medicinecentre.service.interfaces.DoctorService;
import by.guzypaul.medicinecentre.service.interfaces.ProcedureService;
import by.guzypaul.medicinecentre.service.interfaces.UserService;

import javax.servlet.http.HttpServletRequest;
import java.sql.Time;
import java.time.LocalDate;
import java.util.Optional;

public class ChangeAppointmentCommand implements Command {
    private final AppointmentService appointmentService;
    private final UserService userService;
    private final DoctorService doctorService;
    private final ProcedureService procedureService;

    public ChangeAppointmentCommand() {
        appointmentService = ServiceFactory.getInstance().getAppointmentService();
        userService = ServiceFactory.getInstance().getUserService();
        doctorService = ServiceFactory.getInstance().getDoctorService();
        procedureService = ServiceFactory.getInstance().getProcedureService();
    }

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        try {
            String appointmentId = request.getParameter("appointmentId");
            String clientId = request.getParameter("clientId");
            String doctorId = request.getParameter("doctorId");
            String date = request.getParameter("date");
            String startTime = request.getParameter("startTime");
            String endTime = request.getParameter("endTime");
            String procedureId = request.getParameter("procedureId");
            String status = request.getParameter("status");

            if (appointmentId == null || appointmentId.isEmpty()
                    || clientId == null || clientId.isEmpty()
                    || doctorId == null || doctorId.isEmpty()
                    || date == null || date.isEmpty()
                    || startTime == null || startTime.isEmpty()
                    || endTime == null || endTime.isEmpty()
                    || procedureId == null || procedureId.isEmpty()
                    || status == null || status.isEmpty()) {
                request.getSession().setAttribute("isAppointmentChanged", false);
                return new Router("/controller?command=change_appointment_page", Router.Type.REDIRECT);
            }

            Optional<Appointment> appointmentOptional = appointmentService.readById(appointmentId);
            Optional<User> userClientOptional = userService.readById(clientId);
            Optional<Doctor> doctorOptional = doctorService.readById(doctorId);
            Optional<Procedure> procedureOptional = procedureService.readById(procedureId);

            if (appointmentOptional.isPresent() && userClientOptional.isPresent()
                    && doctorOptional.isPresent() && procedureOptional.isPresent()) {
                Appointment appointment = new Appointment(Integer.parseInt(appointmentId), userClientOptional.get(),
                        doctorOptional.get(), LocalDate.parse(date), Time.valueOf(startTime), Time.valueOf(endTime),
                        procedureOptional.get(), status);
                appointmentService.update(appointment);
                request.getSession().setAttribute("isAppointmentChanged", true);
                return new Router("/controller?command=appointments", Router.Type.REDIRECT);
            } else {
                request.getSession().setAttribute("isAppointmentChanged", false);
                return new Router("/controller?command=change_appointment_page", Router.Type.REDIRECT);
            }
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
    }
}
