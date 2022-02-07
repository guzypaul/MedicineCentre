package by.guzypaul.medicinecentre.controller.command.impl;

import by.guzypaul.medicinecentre.controller.command.Command;
import by.guzypaul.medicinecentre.controller.command.CommandException;
import by.guzypaul.medicinecentre.controller.command.Router;
import by.guzypaul.medicinecentre.entity.DoctorSchedule;
import by.guzypaul.medicinecentre.service.ServiceFactory;
import by.guzypaul.medicinecentre.service.exception.ServiceException;
import by.guzypaul.medicinecentre.service.DoctorScheduleService;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * The type Change doctor schedule page command.
 * @author Guziy Paul
 * @see Command
 */
public class ChangeDoctorSchedulePageCommand implements Command {
    private final DoctorScheduleService doctorScheduleService;

    /**
     * Instantiates a new Change doctor schedule page command.
     */
    public ChangeDoctorSchedulePageCommand() {
        doctorScheduleService = ServiceFactory.getInstance().getDoctorScheduleService();
    }

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        try {
            String doctorScheduleId = request.getParameter("doctorScheduleId");

            if (doctorScheduleId == null) {
                doctorScheduleId = request.getSession().getAttribute("doctorScheduleId").toString();
                request.getSession().removeAttribute("doctorScheduleId");
                if (doctorScheduleId == null) {
                    throw new CommandException("Unknown doctor schedule!");
                }
            }
            Optional<DoctorSchedule> doctorScheduleOptional = doctorScheduleService.readById(doctorScheduleId);

            if  (doctorScheduleOptional.isPresent()) {
                request.setAttribute("doctorSchedule", doctorScheduleOptional.get());
                return new Router("/jsp/change_doctor_schedule_page.jsp", Router.Type.FORWARD);
            }

            throw new CommandException("Invalid doctor schedule!");
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
    }
}
