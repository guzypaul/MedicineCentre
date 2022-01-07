package by.guzypaul.medicinecentre.service.interfaces;

import by.guzypaul.medicinecentre.entity.Doctor;
import by.guzypaul.medicinecentre.service.exception.ServiceException;

import java.util.Optional;

public interface DoctorService extends BaseService<Doctor>{
    Optional<Doctor> readByUserId(String id) throws ServiceException;
}
