package by.guzypaul.medicinecentre.controller.command.impl;

import by.guzypaul.medicinecentre.controller.command.Command;
import by.guzypaul.medicinecentre.controller.command.CommandException;
import by.guzypaul.medicinecentre.controller.command.Router;
import by.guzypaul.medicinecentre.entity.Doctor;
import by.guzypaul.medicinecentre.entity.DoctorSchedule;
import by.guzypaul.medicinecentre.entity.User;
import by.guzypaul.medicinecentre.service.ServiceFactory;
import by.guzypaul.medicinecentre.service.exception.ServiceException;
import by.guzypaul.medicinecentre.service.interfaces.AppointmentService;
import by.guzypaul.medicinecentre.service.interfaces.DoctorScheduleService;
import by.guzypaul.medicinecentre.service.interfaces.DoctorService;
import by.guzypaul.medicinecentre.service.interfaces.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class ProfilePageCommand implements Command {
    private final UserService userService;
    private final DoctorService doctorService;
    private final DoctorScheduleService doctorScheduleService;
    private final AppointmentService appointmentService;

    public ProfilePageCommand() {
        userService = ServiceFactory.getInstance().getUserService();
        doctorService = ServiceFactory.getInstance().getDoctorService();
        doctorScheduleService = ServiceFactory.getInstance().getDoctorScheduleService();
        appointmentService = ServiceFactory.getInstance().getAppointmentService();
    }

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        try {
            String role = String.valueOf(request.getSession().getAttribute("role"));
            String userId = request.getSession().getAttribute("userId").toString();
            Optional<User> userOptional = userService.readById(userId);

            if (role.toUpperCase() == "DOCTOR") {
                Optional<Doctor> doctorOptional = doctorService.readByUserId(userId);
                String doctorId = String.valueOf(doctorOptional.get().getId());
                Optional<DoctorSchedule> doctorScheduleOptional = doctorScheduleService.readByDoctorId(doctorId);
                request.setAttribute("doctor", doctorOptional.get());
                request.setAttribute("schedule", doctorScheduleOptional.get());
            }

            if (userOptional.isPresent()) {
                request.setAttribute("user", userOptional.get());
                return new Router("/jsp/profile_page.jsp", Router.Type.FORWARD);
            }

            throw new CommandException("Invalid user");
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
    }
}
