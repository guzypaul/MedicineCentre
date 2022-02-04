package by.guzypaul.medicinecentre.controller.command.impl;

import by.guzypaul.medicinecentre.controller.command.Command;
import by.guzypaul.medicinecentre.controller.command.CommandException;
import by.guzypaul.medicinecentre.controller.command.Router;
import by.guzypaul.medicinecentre.entity.Doctor;
import by.guzypaul.medicinecentre.entity.DoctorSchedule;
import by.guzypaul.medicinecentre.service.ServiceFactory;
import by.guzypaul.medicinecentre.service.exception.ServiceException;
import by.guzypaul.medicinecentre.service.DoctorScheduleService;
import by.guzypaul.medicinecentre.service.DoctorService;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * The type Doctor forward command.
 * @author Guziy Paul
 * @see Command
 */
public class DoctorForwardCommand implements Command {
    private final DoctorService doctorService;
    private final DoctorScheduleService doctorScheduleService;

    /**
     * Instantiates a new Doctor forward command.
     */
    public DoctorForwardCommand() {
        doctorService = ServiceFactory.getInstance().getDoctorService();
        doctorScheduleService = ServiceFactory.getInstance().getDoctorScheduleService();
    }

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        try {
            Optional<Doctor> doctorOptional = doctorService.readById(request.getParameter("doctorId"));
            Optional<DoctorSchedule> doctorSchedule = doctorScheduleService.readByDoctorId(request.getParameter("doctorId"));

            if (doctorOptional.isPresent()) {
                request.setAttribute("doctor", doctorOptional.get());
                request.setAttribute("schedule", doctorSchedule.get());
                return new Router("/jsp/doctor_page.jsp", Router.Type.FORWARD);
            }

            throw new CommandException("Invalid doctor");
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
    }
}
