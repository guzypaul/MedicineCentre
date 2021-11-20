package by.guzypaul.medicinecentre.service.interfaces;

import by.guzypaul.medicinecentre.entity.Procedure;
import by.guzypaul.medicinecentre.service.exception.ServiceException;

import java.util.List;

public interface ProcedureService {
    List<Procedure> readAll() throws ServiceException;
    Procedure readById(Integer id) throws ServiceException;
    boolean deleteById(Integer id) throws ServiceException;
    boolean create(Procedure entity) throws ServiceException;
    boolean update(Procedure entity) throws ServiceException;
}
