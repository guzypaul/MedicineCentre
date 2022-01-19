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

import javax.servlet.http.HttpServletRequest;
import java.sql.Time;
import java.util.Optional;

public class CreateDoctorCommand implements Command {
    private final DoctorService doctorService;
    private final UserService userService;
    private final DoctorScheduleService doctorScheduleService;

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
            String photoName = request.getParameter("photoName");
            String startTime = request.getParameter("startTime");
            String endTime = request.getParameter("endTime");
            String info = request.getParameter("info");

            if (qualification == null || qualification.isEmpty()
                    || rank == null || rank.isEmpty()
                    || userId == null || userId.isEmpty()
                    || photoName == null || photoName.isEmpty()
                    || startTime == null || startTime.isEmpty()
                    || endTime == null || endTime.isEmpty()
                    || info == null || info.isEmpty()) {
                return new Router("/controller?command=create_doctor_page", Router.Type.REDIRECT);
            }

            Optional<User> userOptional = userService.readById(userId);
            if (userOptional.isPresent()) {
                User userDoctor = userOptional.get();                           //todo transaction!!!
                userDoctor.setRole(Role.DOCTOR);
                userService.update(userDoctor);
                Doctor doctor = new Doctor(qualification, rank, userDoctor, photoName);
                doctorService.create(doctor);
                Doctor newCreatedDoctor = doctorService.readByUserId(userId).get();
                DoctorSchedule doctorSchedule = new DoctorSchedule(newCreatedDoctor, Time.valueOf(startTime), Time.valueOf(endTime), info);
                doctorScheduleService.create(doctorSchedule);

                return new Router("/controller?command=doctor_page&doctorId=" + newCreatedDoctor.getId(), Router.Type.REDIRECT);
            }else {

                return new Router("/controller?command=create_doctor_page", Router.Type.REDIRECT);
            }
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
    }
}
