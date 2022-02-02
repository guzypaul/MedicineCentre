package by.guzypaul.medicinecentre.controller.command.impl;

import by.guzypaul.medicinecentre.controller.command.Command;
import by.guzypaul.medicinecentre.controller.command.CommandException;
import by.guzypaul.medicinecentre.controller.command.Router;
import by.guzypaul.medicinecentre.entity.Doctor;
import by.guzypaul.medicinecentre.entity.DoctorSchedule;
import by.guzypaul.medicinecentre.service.ServiceFactory;
import by.guzypaul.medicinecentre.service.exception.ServiceException;
import by.guzypaul.medicinecentre.service.interfaces.DoctorScheduleService;
import by.guzypaul.medicinecentre.service.interfaces.DoctorService;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * The type Delete doctor and schedule page command.
 * @author Guziy Paul
 * @see Command
 */
public class DeleteDoctorAndSchedulePageCommand implements Command {
    private final DoctorService doctorService;
    private final DoctorScheduleService doctorScheduleService;

    /**
     * Instantiates a new Delete doctor and schedule page command.
     */
    public DeleteDoctorAndSchedulePageCommand() {
        doctorService = ServiceFactory.getInstance().getDoctorService();
        doctorScheduleService = ServiceFactory.getInstance().getDoctorScheduleService();
    }

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        try {
            String doctorId = request.getParameter("doctorId");
            Optional<Doctor> doctorOptional = doctorService.readById(doctorId);
            Optional<DoctorSchedule> doctorScheduleOptional = doctorScheduleService.readByDoctorId(doctorId);
            String doctorScheduleId = String.valueOf(doctorScheduleOptional.get().getId());

            if (doctorOptional.isPresent() && doctorScheduleOptional.isPresent()) {
                request.setAttribute("doctorId", doctorId);
                request.setAttribute("doctorScheduleId", doctorScheduleId);
                return new Router("/jsp/delete_doctor_and_schedule_page.jsp", Router.Type.FORWARD);
            }

            throw new CommandException("Invalid appointment");
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
    }
}
