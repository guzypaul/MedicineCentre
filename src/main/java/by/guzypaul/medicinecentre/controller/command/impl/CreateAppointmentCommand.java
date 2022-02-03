package by.guzypaul.medicinecentre.controller.command.impl;

import by.guzypaul.medicinecentre.controller.command.Command;
import by.guzypaul.medicinecentre.controller.command.CommandException;
import by.guzypaul.medicinecentre.controller.command.Router;
import by.guzypaul.medicinecentre.entity.*;
import by.guzypaul.medicinecentre.service.ServiceFactory;
import by.guzypaul.medicinecentre.service.exception.ServiceException;
import by.guzypaul.medicinecentre.service.interfaces.AppointmentService;
import by.guzypaul.medicinecentre.service.interfaces.DoctorService;
import by.guzypaul.medicinecentre.service.interfaces.ProcedureService;
import by.guzypaul.medicinecentre.service.interfaces.UserService;

import javax.servlet.http.HttpServletRequest;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

/**
 * The type Create appointment command.
 * @author Guziy Paul
 * @see Command
 */
public class CreateAppointmentCommand implements Command {
    private final AppointmentService appointmentService;
    private final UserService userService;
    private final DoctorService doctorService;
    private final ProcedureService procedureService;

    /**
     * Instantiates a new Create appointment command.
     */
    public CreateAppointmentCommand() {
        appointmentService = ServiceFactory.getInstance().getAppointmentService();
        userService = ServiceFactory.getInstance().getUserService();
        doctorService = ServiceFactory.getInstance().getDoctorService();
        procedureService = ServiceFactory.getInstance().getProcedureService();
    }

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        try {
            String userId = request.getParameter("userId");
            String doctorId = request.getParameter("doctorId");
            String date = request.getParameter("date");
            String startTimeAsString = request.getParameter("startTime");
            String procedureId = request.getParameter("procedureId");
            String status = request.getParameter("status");

            if (userId == null || userId.isEmpty()
                    || doctorId == null || doctorId.isEmpty()
                    || date == null || date.isEmpty()
                    || startTimeAsString == null || startTimeAsString.isEmpty()
                    || procedureId == null || procedureId.isEmpty()
                    || status == null || status.isEmpty()) {
                request.getSession().setAttribute("isAppointmentCreated", false);

                throw new CommandException("Return on previous page and fill all fields please!");
            }

            Optional<User> userClientOptional = userService.readById(userId);
            Optional<Doctor> doctorOptional = doctorService.readById(doctorId);
            Optional<Procedure> procedureOptional = procedureService.readById(procedureId);

            if (userClientOptional.isPresent() && doctorOptional.isPresent() && procedureOptional.isPresent()) {
                Procedure procedure = procedureOptional.get();
                int duration = procedure.getDuration();
                Time startTime = Time.valueOf(LocalTime.parse(startTimeAsString));
                Time endTime = Time.valueOf(LocalTime.parse(startTimeAsString).plusMinutes(duration));

                Appointment appointment = new Appointment(userClientOptional.get(),
                        doctorOptional.get(), LocalDate.parse(date), startTime, endTime,
                        procedureOptional.get(), AppStatus.valueOf(status));
                appointmentService.create(appointment);
                request.getSession().setAttribute("isAppointmentCreated", true);

                return new Router("/controller?command=appointments", Router.Type.REDIRECT);
            } else {
                throw new CommandException("Return and fill all fields correctly please!");
            }
        } catch (ServiceException e) {
            throw new CommandException("Return and fill all fields correctly please!");
        }
    }
}
