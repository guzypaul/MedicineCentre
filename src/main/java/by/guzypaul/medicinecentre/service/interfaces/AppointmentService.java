package by.guzypaul.medicinecentre.service.interfaces;

import by.guzypaul.medicinecentre.entity.Appointment;
import by.guzypaul.medicinecentre.service.exception.ServiceException;

import java.util.List;

public interface AppointmentService extends BaseService<Appointment> {

    List<Appointment> readByDoctorId(String id) throws ServiceException;
}
