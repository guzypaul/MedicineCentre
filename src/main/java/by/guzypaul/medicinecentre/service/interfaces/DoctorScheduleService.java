package by.guzypaul.medicinecentre.service.interfaces;

import by.guzypaul.medicinecentre.entity.DoctorSchedule;
import by.guzypaul.medicinecentre.service.exception.ServiceException;

import java.util.Optional;

public interface DoctorScheduleService extends BaseService<DoctorSchedule>{
    Optional<DoctorSchedule> readByDoctorId(String id) throws ServiceException;
}
