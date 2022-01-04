package by.guzypaul.medicinecentre.dao.interfaces;

import by.guzypaul.medicinecentre.dao.DaoException;
import by.guzypaul.medicinecentre.entity.Appointment;

import java.util.List;

public interface AppointmentDao extends BaseDao<Integer, Appointment>{
    List<Appointment> readByDoctorId(Integer id) throws DaoException;
}
