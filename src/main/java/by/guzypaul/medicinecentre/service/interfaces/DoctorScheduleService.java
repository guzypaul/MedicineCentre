package by.guzypaul.medicinecentre.service.interfaces;

import by.guzypaul.medicinecentre.entity.DoctorSchedule;
import by.guzypaul.medicinecentre.service.exception.ServiceException;

import java.util.Optional;

/**
 * The interface Doctor schedule service.
 * @author Guziy Paul
 */
public interface DoctorScheduleService extends BaseService<DoctorSchedule>{
    /**
     * Read by doctor id optional.
     *
     * @param id the id
     * @return the optional
     * @throws ServiceException the service exception
     */
    Optional<DoctorSchedule> readByDoctorId(String id) throws ServiceException;
}
