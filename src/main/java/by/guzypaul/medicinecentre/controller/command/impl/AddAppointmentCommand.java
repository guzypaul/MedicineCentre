package by.guzypaul.medicinecentre.controller.command.impl;

import by.guzypaul.medicinecentre.controller.command.*;
import by.guzypaul.medicinecentre.dao.impl.AppointmentDaoImpl;
import by.guzypaul.medicinecentre.dao.impl.DoctorScheduleDaoImpl;
import by.guzypaul.medicinecentre.dao.impl.ProcedureDaoImpl;
import by.guzypaul.medicinecentre.entity.Appointment;
import by.guzypaul.medicinecentre.entity.User;
import by.guzypaul.medicinecentre.service.exception.ServiceException;
import by.guzypaul.medicinecentre.service.impl.AppointmentServiceImpl;
import by.guzypaul.medicinecentre.service.impl.DoctorScheduleServiceImpl;
import by.guzypaul.medicinecentre.service.interfaces.AppointmentService;
import by.guzypaul.medicinecentre.service.interfaces.DoctorScheduleService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.sql.Time;

public class AddAppointmentCommand implements Command {
    private static final Logger logger = LogManager.getLogger();
    AppointmentService appointmentService = new AppointmentServiceImpl(new AppointmentDaoImpl(),new ProcedureDaoImpl());
    DoctorScheduleService doctorScheduleService = new DoctorScheduleServiceImpl(new DoctorScheduleDaoImpl());
    Appointment appointment = new Appointment();

    @Override
    public Router execute(HttpServletRequest request) {
        logger.log(Level.DEBUG, "execute method AddProcedureCommand");
        Router router = new Router();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(ParameterAndAttribute.USER);
        String userId = Long.toString(user.getId());
        String doctorId =request.getParameter(ParameterAndAttribute.DOCTOR_ID);
        String procedureId =request.getParameter(ParameterAndAttribute.PROCEDURE_ID);
        String scheduleId = request.getParameter(ParameterAndAttribute.SCHEDULE_ID);
        String time = request.getParameter(ParameterAndAttribute.START_TIME);
//        appointment.setClientId(Integer.parseInt(userId));
//        appointment.setDoctorId(Integer.parseInt(doctorId));
//        appointment.setProcedureId(Integer.parseInt(procedureId));

        appointment.setStartTime(Time.valueOf(time));
        try {
            String date = doctorScheduleService.readById(Integer.parseInt(scheduleId)).getDate().toString();
            appointment.setDate(Date.valueOf(date));
            if (appointmentService.create(appointment)) {
                session.setAttribute(ParameterAndAttribute.MESSAGE_FOR_USER, Message.SUCCESSFUL);
                String page = request.getContextPath() + PagePath.TO_PERSONAL_PAGE;
                router.setPagePath(page);
                router.setType(Router.Type.REDIRECT);
            }
        } catch (ServiceException e) {
            logger.log(Level.ERROR, "ServiceException: " + e);
            request.setAttribute(ParameterAndAttribute.EXCEPTION, "ServiceException");
            request.setAttribute(ParameterAndAttribute.ERROR_MESSAGE, e);
            router.setPagePath(PagePath.ERROR);
        }
        return router;
    }
}
