package by.guzypaul.medicinecentre.service;

import by.guzypaul.medicinecentre.service.impl.*;
import by.guzypaul.medicinecentre.service.interfaces.*;

public class ServiceFactory {
    private static final ServiceFactory INSTANCE = new ServiceFactory();
    private final ProcedureService procedureService;
    private final AppointmentService appointmentService;
    private final UserService userService;
    private final DoctorService doctorService;
    private final DoctorScheduleService doctorScheduleService;

    public ServiceFactory() {
        procedureService = new ProcedureServiceImpl();
        appointmentService = new AppointmentServiceImpl();
        userService = new UserServiceImpl();
        doctorService = new DoctorServiceImpl();
        doctorScheduleService = new DoctorScheduleServiceImpl();
    }

    public static ServiceFactory getInstance() {
        return INSTANCE;
    }

    public ProcedureService getProcedureService() {
        return procedureService;
    }

    public AppointmentService getAppointmentService() {
        return appointmentService;
    }

    public UserService getUserService() {
        return userService;
    }

    public DoctorService getDoctorService() {
        return doctorService;
    }

    public DoctorScheduleService getDoctorScheduleService() {
        return doctorScheduleService;
    }
}

