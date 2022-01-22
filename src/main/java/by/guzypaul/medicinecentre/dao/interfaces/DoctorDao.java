package by.guzypaul.medicinecentre.dao.interfaces;

import by.guzypaul.medicinecentre.dao.DaoException;
import by.guzypaul.medicinecentre.entity.Doctor;
import by.guzypaul.medicinecentre.entity.User;

import java.util.List;
import java.util.Optional;

public interface DoctorDao extends BaseDao<Integer, Doctor> {
    List<Doctor> readByQualification(String qualification) throws DaoException;

    Optional<Doctor> readByUserId(Integer id) throws DaoException;

    void deleteDoctorWithScheduleAndChangeUserRole(Integer doctorId, Integer scheduleId, User user) throws DaoException;
}
