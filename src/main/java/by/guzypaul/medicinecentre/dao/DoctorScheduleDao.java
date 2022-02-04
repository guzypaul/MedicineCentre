package by.guzypaul.medicinecentre.dao;

import by.guzypaul.medicinecentre.entity.DoctorSchedule;

import java.util.Optional;

/**
 * The interface Doctor schedule dao.
 * @author Guziy Paul
 * @see BaseDao
 */
public interface DoctorScheduleDao extends BaseDao<Integer, DoctorSchedule>{
    /**
     * Read by doctor id optional.
     *
     * @param doctorId the doctor id
     * @return the optional
     * @throws DaoException the dao exception
     */
    Optional<DoctorSchedule> readByDoctorId(Integer doctorId) throws DaoException;
}
