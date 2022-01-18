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

public class ChangeDoctorCommand implements Command {
    private final DoctorService doctorService;

    public ChangeDoctorCommand() {
        doctorService = ServiceFactory.getInstance().getDoctorService();
    }

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        try {
            String doctorId = request.getParameter("doctorId");
            String qualification = request.getParameter("qualification");
            String rank = request.getParameter("rank");
            String photoName = request.getParameter("photoName");

            if (doctorId == null || doctorId.isEmpty()
                    || qualification == null || qualification.isEmpty()
                    || rank == null || rank.isEmpty()
                    || photoName == null || photoName.isEmpty()) {
                return new Router("/controller?command=change_doctor_page", Router.Type.REDIRECT);
            }

            Optional<Doctor> doctorOptional = doctorService.readById(doctorId);

            if (doctorOptional.isPresent()) {
                Doctor doctor = new Doctor(Integer.parseInt(doctorId), qualification, rank, photoName);
                doctorService.update(doctor);

                return new Router("/controller?command=doctor_page&doctorId=" + doctorId, Router.Type.REDIRECT);
            } else {
                return new Router("/controller?command=change_doctor_page", Router.Type.REDIRECT);
            }

        } catch (ServiceException e) {
            throw new CommandException(e);
        }
    }
}
