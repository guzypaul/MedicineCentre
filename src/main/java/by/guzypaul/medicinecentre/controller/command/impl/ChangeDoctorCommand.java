package by.guzypaul.medicinecentre.controller.command.impl;

import by.guzypaul.medicinecentre.controller.command.Command;
import by.guzypaul.medicinecentre.controller.command.CommandException;
import by.guzypaul.medicinecentre.controller.command.Router;
import by.guzypaul.medicinecentre.entity.Doctor;
import by.guzypaul.medicinecentre.service.ServiceFactory;
import by.guzypaul.medicinecentre.service.exception.ServiceException;
import by.guzypaul.medicinecentre.service.interfaces.DoctorService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * The type Change doctor command.
 * @author Guziy Paul
 * @see Command
 */
public class ChangeDoctorCommand implements Command {
    private final DoctorService doctorService;

    /**
     * Instantiates a new Change doctor command.
     */
    public ChangeDoctorCommand() {
        doctorService = ServiceFactory.getInstance().getDoctorService();
    }

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        try {
            String doctorId = request.getParameter("doctorId");
            String qualification = request.getParameter("qualification");
            String rank = request.getParameter("rank");
            String currentPhotoName = request.getParameter("photoName");

            if (doctorId == null || doctorId.isEmpty()
                    || qualification == null || qualification.isEmpty()
                    || rank == null || rank.isEmpty()
                    || currentPhotoName == null || currentPhotoName.isEmpty()) {
                request.getSession().setAttribute("isDoctorChanged", false);

                request.getSession().setAttribute("doctorId", doctorId);

                return new Router("/controller?command=change_doctor_page", Router.Type.REDIRECT);
            }

            Optional<Doctor> doctorOptional = doctorService.readById(doctorId);

            if (doctorOptional.isPresent()) {
                Doctor doctor = new Doctor(Integer.parseInt(doctorId), qualification, rank);

                for (Part part : request.getParts()) {
                    if (part.getName().equals("doctor-picture")) {
                        InputStream inputStream = part.getInputStream();
                        InputStreamReader isr = new InputStreamReader(inputStream);
                        new BufferedReader(isr)
                                .lines()
                                .collect(Collectors.joining("\n"));
                        if (!part.getSubmittedFileName().isEmpty()
                                && ("doctor_" + doctor.getQualification() + "_" + part.getSubmittedFileName()) != currentPhotoName) {
                            String pictureName = "doctor_" + doctor.getQualification() + "_" + part.getSubmittedFileName();
                            doctor.setPhotoName(pictureName);
                            part.write(pictureName);
                        } else {
                            doctor.setPhotoName(currentPhotoName);
                        }
                    }
                }

                boolean isDoctorChanged = doctorService.update(doctor);
                if (isDoctorChanged) {
                    request.getSession().setAttribute("isDoctorChanged", true);
                    return new Router("/controller?command=doctor_page&doctorId=" + doctorId, Router.Type.REDIRECT);
                }
                throw new CommandException("Doctor updating was crashed!");
            } else {
                request.getSession().setAttribute("isDoctorChanged", false);
                return new Router("/controller?command=change_doctor_page", Router.Type.REDIRECT);
            }
        } catch (ServiceException | IOException | ServletException e) {
            throw new CommandException(e);
        }
    }
}
