package by.guzypaul.medicinecentre.service.checker;

import by.guzypaul.medicinecentre.dao.AppointmentDao;
import by.guzypaul.medicinecentre.dao.DaoException;
import by.guzypaul.medicinecentre.dao.DaoFactory;
import by.guzypaul.medicinecentre.entity.Appointment;

import java.util.List;

public class AppointmentDuplicationChecker {
    private final AppointmentDao appointmentDao;

    public AppointmentDuplicationChecker() {
        appointmentDao = DaoFactory.getInstance().getAppointmentDao();
    }

    public boolean checkDuplication(Appointment appointment) throws DaoException { //todo why skipped
        List<Appointment> appointmentWithSpecificDoctorList = appointmentDao.readByDoctorId(appointment.getDoctor().getId());
        for (Appointment currentAppointment : appointmentWithSpecificDoctorList) {
            if (currentAppointment.getDate().equals(appointment.getDate())
                    && currentAppointment.getStartTime().equals((appointment.getStartTime()))) {

                return false;
            }
        }
        return true;
    }
}
