package by.guzypaul.medicinecentre.controller.command.impl;

import by.guzypaul.medicinecentre.controller.command.Command;
import by.guzypaul.medicinecentre.controller.command.CommandException;
import by.guzypaul.medicinecentre.controller.command.Router;
import by.guzypaul.medicinecentre.entity.Doctor;
import by.guzypaul.medicinecentre.service.ServiceFactory;
import by.guzypaul.medicinecentre.service.exception.ServiceException;
import by.guzypaul.medicinecentre.service.interfaces.DoctorService;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class ChangeDoctorPageCommand implements Command {
    private final DoctorService doctorService;

    public ChangeDoctorPageCommand() {
        doctorService = ServiceFactory.getInstance().getDoctorService();
    }

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        try {
            String doctorId = request.getParameter("doctorId");
            Optional<Doctor> doctorOptional = doctorService.readById(doctorId);

            if  (doctorOptional.isPresent()) {
                request.setAttribute("doctor", doctorOptional.get());
                return new Router("/jsp/change_doctor_page.jsp", Router.Type.FORWARD);
            }

            throw new CommandException("Invalid doctor");
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
    }
}
