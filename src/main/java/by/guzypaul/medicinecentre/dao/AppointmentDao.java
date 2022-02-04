package by.guzypaul.medicinecentre.dao;

import by.guzypaul.medicinecentre.entity.Appointment;

import java.util.List;

/**
 * The interface Appointment dao.
 * @author Guziy Paul
 * @see BaseDao
 */
public interface AppointmentDao extends BaseDao<Integer, Appointment>{
    /**
     * Read by doctor id list.
     *
     * @param id the id
     * @return the list
     * @throws DaoException the dao exception
     */
    List<Appointment> readByDoctorId(Integer id) throws DaoException;

    /**
     * Read by client id list.
     *
     * @param clientId the client id
     * @return the list
     * @throws DaoException the dao exception
     */
    List<Appointment> readByClientId(Integer clientId) throws DaoException;
}
