package by.guzypaul.medicinecentre.controller.command.impl;

import by.guzypaul.medicinecentre.controller.command.Command;
import by.guzypaul.medicinecentre.controller.command.CommandException;
import by.guzypaul.medicinecentre.controller.command.Router;
import by.guzypaul.medicinecentre.entity.Doctor;
import by.guzypaul.medicinecentre.entity.Qualification;
import by.guzypaul.medicinecentre.service.ServiceFactory;
import by.guzypaul.medicinecentre.service.exception.ServiceException;
import by.guzypaul.medicinecentre.service.DoctorService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The type Change doctor page command.
 */
public class ChangeDoctorPageCommand implements Command {
    private final DoctorService doctorService;

    /**
     * Instantiates a new Change doctor page command.
     * @author Guziy Paul
     * @see Command
     */
    public ChangeDoctorPageCommand() {
        doctorService = ServiceFactory.getInstance().getDoctorService();
    }

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        try {
            String doctorId = request.getParameter("doctorId");

            if (doctorId == null) {
                doctorId = request.getSession().getAttribute("doctorId").toString();
                request.removeAttribute("doctorId");
                if (doctorId == null) {
                    throw new CommandException("Unknown doctor!");
                }
            }

            Optional<Doctor> doctorOptional = doctorService.readById(doctorId);

            if  (doctorOptional.isPresent()) {
                List<String> qualificationList = new ArrayList<>();
                for (Qualification qualification : Qualification.values()) {
                    String qualificationName = qualification.getName();
                    qualificationList.add(qualificationName);
                }
                request.setAttribute("qualificationList", qualificationList);
                request.setAttribute("doctor", doctorOptional.get());
                return new Router("/jsp/change_doctor_page.jsp", Router.Type.FORWARD);
            }

            throw new CommandException("Invalid doctor");
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
    }
}
