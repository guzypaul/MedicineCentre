package by.guzypaul.medicinecentre.dao;

import by.guzypaul.medicinecentre.entity.Doctor;
import by.guzypaul.medicinecentre.entity.User;

import java.util.List;
import java.util.Optional;

/**
 * The interface Doctor dao.
 * @author Guziy Paul
 * @see BaseDao
 */
public interface DoctorDao extends BaseDao<Integer, Doctor> {
    /**
     * Read by qualification list.
     *
     * @param qualification the qualification
     * @return the list
     * @throws DaoException the dao exception
     */
    List<Doctor> readByQualification(String qualification) throws DaoException;

    /**
     * Read by user id optional.
     *
     * @param id the id
     * @return the optional
     * @throws DaoException the dao exception
     */
    Optional<Doctor> readByUserId(Integer id) throws DaoException;

    /**
     * Delete doctor with schedule and change user role.
     *
     * @param doctorId   the doctor id
     * @param scheduleId the schedule id
     * @param user       the user
     * @throws DaoException the dao exception
     */
    void deleteDoctorWithScheduleAndChangeUserRole(Integer doctorId, Integer scheduleId, User user) throws DaoException;
}
