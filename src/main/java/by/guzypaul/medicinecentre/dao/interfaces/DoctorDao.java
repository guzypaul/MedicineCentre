package by.guzypaul.medicinecentre.dao.interfaces;

import by.guzypaul.medicinecentre.dao.DaoException;
import by.guzypaul.medicinecentre.entity.Doctor;

import java.util.Optional;

public interface DoctorDao extends BaseDao<Integer, Doctor>{
    Optional<Doctor> readByUserId(Integer id) throws DaoException;
}
