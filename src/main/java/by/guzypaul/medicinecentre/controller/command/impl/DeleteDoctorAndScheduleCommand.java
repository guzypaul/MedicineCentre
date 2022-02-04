package by.guzypaul.medicinecentre.controller.command.impl;

import by.guzypaul.medicinecentre.controller.command.Command;
import by.guzypaul.medicinecentre.controller.command.CommandException;
import by.guzypaul.medicinecentre.controller.command.Router;
import by.guzypaul.medicinecentre.entity.Doctor;
import by.guzypaul.medicinecentre.entity.DoctorSchedule;
import by.guzypaul.medicinecentre.entity.Role;
import by.guzypaul.medicinecentre.entity.User;
import by.guzypaul.medicinecentre.service.ServiceFactory;
import by.guzypaul.medicinecentre.service.exception.ServiceException;
import by.guzypaul.medicinecentre.service.DoctorScheduleService;
import by.guzypaul.medicinecentre.service.DoctorService;
import by.guzypaul.medicinecentre.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * The type Delete doctor and schedule command.
 * @author Guziy Paul
 * @see Command
 */
public class DeleteDoctorAndScheduleCommand implements Command {
    private final DoctorService doctorService;
    private final DoctorScheduleService doctorScheduleService;
    private final UserService userService;

    /**
     * Instantiates a new Delete doctor and schedule command.
     */
    public DeleteDoctorAndScheduleCommand() {
        doctorService = ServiceFactory.getInstance().getDoctorService();
        doctorScheduleService = ServiceFactory.getInstance().getDoctorScheduleService();
        userService = ServiceFactory.getInstance().getUserService();
    }

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        try {
            String doctorId = request.getParameter("doctorId");
            String doctorScheduleId = request.getParameter("doctorScheduleId");
            Optional<Doctor> doctorOptional = doctorService.readById(doctorId);
            Optional<DoctorSchedule> doctorScheduleOptional = doctorScheduleService.readById(doctorScheduleId);
            String userId = String.valueOf(doctorOptional.get().getDoctorInfo().getId());
            Optional<User> userOptional = userService.readById(userId);

            if (doctorOptional.isPresent() && doctorScheduleOptional.isPresent() && userOptional.isPresent()) {
                User user = userOptional.get();
                user.setRole(Role.USER);
                doctorService.deleteDoctorWithScheduleAndChangeUserRole(doctorId, doctorScheduleId, user);
                request.getSession().setAttribute("isDoctorAndScheduleDeleted", true);

                return new Router("/controller?command=doctors", Router.Type.REDIRECT);
            }

            throw new CommandException("Invalid doctor or schedule, or user!");
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
    }
}
