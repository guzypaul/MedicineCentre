package by.guzypaul.medicinecentre.service;

import by.guzypaul.medicinecentre.service.impl.*;
import by.guzypaul.medicinecentre.service.interfaces.*;

/**
 * The type Service factory.
 * @author Guziy Paul
 */
public class ServiceFactory {
    private static final ServiceFactory INSTANCE = new ServiceFactory();
    private final ProcedureService procedureService;
    private final AppointmentService appointmentService;
    private final UserService userService;
    private final DoctorService doctorService;
    private final DoctorScheduleService doctorScheduleService;

    /**
     * Instantiates a new Service factory.
     */
    public ServiceFactory() {
        procedureService = new ProcedureServiceImpl();
        appointmentService = new AppointmentServiceImpl();
        userService = new UserServiceImpl();
        doctorService = new DoctorServiceImpl();
        doctorScheduleService = new DoctorScheduleServiceImpl();
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static ServiceFactory getInstance() {
        return INSTANCE;
    }

    /**
     * Gets procedure service.
     *
     * @return the procedure service
     */
    public ProcedureService getProcedureService() {
        return procedureService;
    }

    /**
     * Gets appointment service.
     *
     * @return the appointment service
     */
    public AppointmentService getAppointmentService() {
        return appointmentService;
    }

    /**
     * Gets user service.
     *
     * @return the user service
     */
    public UserService getUserService() {
        return userService;
    }

    /**
     * Gets doctor service.
     *
     * @return the doctor service
     */
    public DoctorService getDoctorService() {
        return doctorService;
    }

    /**
     * Gets doctor schedule service.
     *
     * @return the doctor schedule service
     */
    public DoctorScheduleService getDoctorScheduleService() {
        return doctorScheduleService;
    }
}

