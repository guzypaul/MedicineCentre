package by.guzypaul.medicinecentre.dao.interfaces;

import by.guzypaul.medicinecentre.dao.DaoException;
import by.guzypaul.medicinecentre.entity.DoctorSchedule;

import java.util.Optional;

public interface DoctorScheduleDao extends BaseDao<Integer, DoctorSchedule>{
    Optional<DoctorSchedule> readByDoctorId(Integer doctorId) throws DaoException;
}
