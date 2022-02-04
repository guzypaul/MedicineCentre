package by.guzypaul.medicinecentre.dao;

import by.guzypaul.medicinecentre.dao.impl.*;

/**
 * The type Dao factory.
 * @author Guziy Paul
 */
public class DaoFactory {
    private static final DaoFactory INSTANCE = new DaoFactory();
    private final ProcedureDao procedureDao;
    private final UserDao userDao;
    private final DoctorDao doctorDao;
    private final DoctorScheduleDao doctorScheduleDao;
    private final AppointmentDao appointmentDao;

    /**
     * Instantiates a new Dao factory.
     */
    public DaoFactory() {
        procedureDao = new ProcedureDaoImpl();
        userDao = new UserDaoImpl();
        doctorDao = new DoctorDaoImpl();
        doctorScheduleDao = new DoctorScheduleDaoImpl();
        appointmentDao = new AppointmentDaoImpl();
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static DaoFactory getInstance() {
        return INSTANCE;
    }

    /**
     * Gets procedure dao.
     *
     * @return the procedure dao
     */
    public ProcedureDao getProcedureDao() {
        return procedureDao;
    }

    /**
     * Gets user dao.
     *
     * @return the user dao
     */
    public UserDao getUserDao() {return userDao; }

    /**
     * Gets doctor dao.
     *
     * @return the doctor dao
     */
    public DoctorDao getDoctorDao() {
        return doctorDao;
    }

    /**
     * Gets doctor schedule dao.
     *
     * @return the doctor schedule dao
     */
    public DoctorScheduleDao getDoctorScheduleDao() {
        return doctorScheduleDao;
    }

    /**
     * Gets appointment dao.
     *
     * @return the appointment dao
     */
    public AppointmentDao getAppointmentDao() {
        return appointmentDao;
    }
}
