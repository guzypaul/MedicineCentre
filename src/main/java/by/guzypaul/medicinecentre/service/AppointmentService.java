package by.guzypaul.medicinecentre.service;

import by.guzypaul.medicinecentre.entity.Appointment;
import by.guzypaul.medicinecentre.service.exception.ServiceException;

import java.util.List;

/**
 * The interface Appointment service.
 * @author Guziy Paul
 */
public interface AppointmentService extends BaseService<Appointment> {

    /**
     * Read by doctor id list.
     *
     * @param id the id
     * @return the list
     * @throws ServiceException the service exception
     */
    List<Appointment> readByDoctorId(String id) throws ServiceException;

    /**
     * Read by client id list.
     *
     * @param clientId the client id
     * @return the list
     * @throws ServiceException the service exception
     */
    List<Appointment> readByClientId(String clientId) throws ServiceException;
}
