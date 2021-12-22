package by.guzypaul.medicinecentre.dao;

import by.guzypaul.medicinecentre.dao.impl.*;
import by.guzypaul.medicinecentre.dao.interfaces.*;

public class DaoFactory {
    private static final DaoFactory INSTANCE = new DaoFactory();
    private final ProcedureDao procedureDao;
    private final UserDao userDao;
    private final DoctorDao doctorDao;
    private final DoctorScheduleDao doctorScheduleDao;
    private final AppointmentDao appointmentDao;

    public DaoFactory() {
        procedureDao = new ProcedureDaoImpl();
        userDao = new UserDaoImpl();
        doctorDao = new DoctorDaoImpl();
        doctorScheduleDao = new DoctorScheduleDaoImpl();
        appointmentDao = new AppointmentDaoImpl();
    }

    public static DaoFactory getInstance() {
        return INSTANCE;
    }

    public ProcedureDao getProcedureDao() {
        return procedureDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public DoctorDao getDoctorDao() {
        return doctorDao;
    }

    public DoctorScheduleDao getDoctorScheduleDao() {
        return doctorScheduleDao;
    }

    public AppointmentDao getAppointmentDao() {
        return appointmentDao;
    }
}
