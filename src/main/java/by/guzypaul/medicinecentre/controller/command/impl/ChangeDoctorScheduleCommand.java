package by.guzypaul.medicinecentre.controller.command.impl;

import by.guzypaul.medicinecentre.controller.command.Command;
import by.guzypaul.medicinecentre.controller.command.CommandException;
import by.guzypaul.medicinecentre.controller.command.Router;
import by.guzypaul.medicinecentre.entity.DoctorSchedule;
import by.guzypaul.medicinecentre.service.ServiceFactory;
import by.guzypaul.medicinecentre.service.exception.ServiceException;
import by.guzypaul.medicinecentre.service.interfaces.DoctorScheduleService;

import javax.servlet.http.HttpServletRequest;
import java.sql.Time;
import java.util.Optional;

public class ChangeDoctorScheduleCommand implements Command {
    private final DoctorScheduleService doctorScheduleService;

    public ChangeDoctorScheduleCommand() {
        doctorScheduleService = ServiceFactory.getInstance().getDoctorScheduleService();
    }

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        try {
            String doctorScheduleId = request.getParameter("doctorScheduleId");
            String startTime = request.getParameter("startTime");
            String endTime = request.getParameter("endTime");
            String info = request.getParameter("info");
            String doctorId = request.getParameter("doctorId");

            if (doctorScheduleId == null || doctorScheduleId.isEmpty()
                    || startTime == null || startTime.isEmpty()
                    || endTime == null || endTime.isEmpty()
                    || info == null || info.isEmpty()) {
                return new Router("/controller?command=change_doctor_schedule_page", Router.Type.REDIRECT);
            }

            Optional<DoctorSchedule> doctorScheduleOptional = doctorScheduleService.readById(doctorScheduleId);

            if (doctorScheduleOptional.isPresent()) {
                DoctorSchedule doctorSchedule = new DoctorSchedule(Integer.parseInt(doctorScheduleId),
                        Time.valueOf(startTime), Time.valueOf(endTime), info);
                doctorScheduleService.update(doctorSchedule);

                return new Router("/controller?command=doctor_page&doctorId=" + doctorId, Router.Type.REDIRECT);
            } else {
                return new Router("/controller?command=change_doctor_schedule_page", Router.Type.REDIRECT);
            }

        } catch (ServiceException e) {
            throw new CommandException(e);
        }
    }
}