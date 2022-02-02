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
import by.guzypaul.medicinecentre.service.interfaces.DoctorScheduleService;
import by.guzypaul.medicinecentre.service.interfaces.DoctorService;
import by.guzypaul.medicinecentre.service.interfaces.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Time;
import java.time.LocalTime;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * The type Create doctor command.
 * @author Guziy Paul
 * @see Command
 */
public class CreateDoctorCommand implements Command {
    private final DoctorService doctorService;
    private final UserService userService;
    private final DoctorScheduleService doctorScheduleService;

    /**
     * Instantiates a new Create doctor command.
     */
    public CreateDoctorCommand() {
        doctorService = ServiceFactory.getInstance().getDoctorService();
        userService = ServiceFactory.getInstance().getUserService();
        doctorScheduleService = ServiceFactory.getInstance().getDoctorScheduleService();
    }

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        try {
            String qualification = request.getParameter("qualification");
            String rank = request.getParameter("rank");
            String userId = request.getParameter("userId");
            String startTime = request.getParameter("startTime");
            String endTime = request.getParameter("endTime");
            String info = request.getParameter("info");

            if (qualification == null || qualification.isEmpty()
                    || rank == null || rank.isEmpty()
                    || userId == null || userId.isEmpty()
                    || startTime == null || startTime.isEmpty()
                    || endTime == null || endTime.isEmpty()
                    || info == null || info.isEmpty()) {
                request.getSession().setAttribute("isDoctorCreated", false);

                return new Router("/controller?command=create_doctor_page", Router.Type.REDIRECT);
            }

            Optional<User> userOptional = userService.readById(userId);
            if (userOptional.isPresent()) {
                User userDoctor = userOptional.get();
                userDoctor.setRole(Role.DOCTOR);
                userService.update(userDoctor);
                Doctor doctor = new Doctor(qualification, rank, userDoctor);

                for (Part part : request.getParts()) {
                    if (part.getName().equals("doctor-picture")) {
                        InputStream inputStream = part.getInputStream();
                        InputStreamReader isr = new InputStreamReader(inputStream);
                        new BufferedReader(isr)
                                .lines()
                                .collect(Collectors.joining("\n"));
                        if (!part.getSubmittedFileName().isEmpty()) {
                            String pictureName = "doctor_" + doctor.getQualification() + "_" + part.getSubmittedFileName();
                            doctor.setPhotoName(pictureName);
                            part.write(pictureName);
                        }
                    }
                }

                doctorService.create(doctor);
                if (doctorService.readByUserId(userId).isPresent()) {
                    Doctor newCreatedDoctor = doctorService.readByUserId(userId).get();
                    DoctorSchedule doctorSchedule = new DoctorSchedule(newCreatedDoctor,
                            Time.valueOf(LocalTime.parse(startTime)), Time.valueOf(LocalTime.parse(endTime)), info);
                    doctorScheduleService.create(doctorSchedule);
                    request.getSession().setAttribute("isDoctorCreated", true);

                    return new Router("/controller?command=doctor_page&doctorId=" + newCreatedDoctor.getId(), Router.Type.REDIRECT);
                }
                throw new CommandException("Doctor creating was crashed!");
            } else {
                request.getSession().setAttribute("isDoctorCreated", false);

                return new Router("/controller?command=create_doctor_page", Router.Type.REDIRECT);
            }
        } catch (ServiceException | IOException | ServletException e) {
            throw new CommandException(e);
        }
    }
}
