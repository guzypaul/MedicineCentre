package by.guzypaul.medicinecentre.service.checker;

import by.guzypaul.medicinecentre.dao.AppointmentDao;
import by.guzypaul.medicinecentre.dao.DaoException;
import by.guzypaul.medicinecentre.dao.DaoFactory;
import by.guzypaul.medicinecentre.entity.Appointment;

public class AppointmentUpdatingDuplicationChecker {
    private final AppointmentDao appointmentDao;

    public AppointmentUpdatingDuplicationChecker() {
        appointmentDao = DaoFactory.getInstance().getAppointmentDao();
    }

    public boolean checkDuplication(Appointment appointment) throws DaoException {
        return appointmentDao.readByDoctorId(appointment.getDoctor().getId()).stream()
                .noneMatch((currentAppointment -> currentAppointment.getDate().equals(appointment.getDate())
                        && currentAppointment.getStartTime().equals(appointment.getStartTime())
                        && currentAppointment.getId() != appointment.getId()));
    }
}
