package by.guzypaul.medicinecentre.service;

import by.guzypaul.medicinecentre.entity.Doctor;
import by.guzypaul.medicinecentre.entity.User;
import by.guzypaul.medicinecentre.service.exception.ServiceException;

import java.util.List;
import java.util.Optional;

/**
 * The interface Doctor service.
 * @author Guziy Paul
 */
public interface DoctorService extends BaseService<Doctor> {
    /**
     * Read by qualification list.
     *
     * @param qualification the qualification
     * @return the list
     * @throws ServiceException the service exception
     */
    List<Doctor> readByQualification(String qualification) throws ServiceException;

    /**
     * Read by user id optional.
     *
     * @param id the id
     * @return the optional
     * @throws ServiceException the service exception
     */
    Optional<Doctor> readByUserId(String id) throws ServiceException;

    /**
     * Delete doctor with schedule and change user role.
     *
     * @param doctorId   the doctor id
     * @param scheduleId the schedule id
     * @param user       the user
     * @throws ServiceException the service exception
     */
    void deleteDoctorWithScheduleAndChangeUserRole(String doctorId, String scheduleId, User user) throws ServiceException;
}
