package by.guzypaul.medicinecentre.service.impl;

import by.guzypaul.medicinecentre.dao.DaoException;
import by.guzypaul.medicinecentre.dao.interfaces.ProcedureDao;
import by.guzypaul.medicinecentre.entity.Procedure;
import by.guzypaul.medicinecentre.service.exception.ServiceException;
import by.guzypaul.medicinecentre.service.interfaces.ProcedureService;
import by.guzypaul.medicinecentre.validator.ProcedureValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ProcedureServiceImpl implements ProcedureService {
    private static final Logger logger = LogManager.getLogger();
    private final ProcedureDao procedureDao;

    public ProcedureServiceImpl(ProcedureDao procedureDao) {
        this.procedureDao = procedureDao;
    }

    @Override
    public List<Procedure> readAll() throws ServiceException {
        logger.log(Level.DEBUG, "readAll()");
        try {
            List<Procedure> procedures;
            procedures = procedureDao.readAll();
            return procedures;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Procedure readById(Integer id) throws ServiceException {
        logger.log(Level.DEBUG, "readById(), procedure id:" + id);
        try {
            Procedure procedure;
            procedure = procedureDao.readById(id);
            return procedure;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean deleteById(Integer id) throws ServiceException {
        logger.log(Level.DEBUG, "deleteById(), procedure id:" + id);
        try {
            return procedureDao.deleteById(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean create(Procedure entity) throws ServiceException {
        logger.log(Level.DEBUG, "create() " + entity);
        try {
            return procedureDao.create(entity);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean update(Procedure entity) throws ServiceException {
        logger.log(Level.DEBUG, "update() " + entity);
        try {
            return procedureDao.update(entity);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean checkData(Procedure entity) {
        boolean isValid = true;

        if (!ProcedureValidator.isValidDuration(entity.getDuration())) {
            isValid = false;
        }
        if (!ProcedureValidator.isValidName(entity.getName())) {
            isValid = false;
        }
        if (!ProcedureValidator.isValidImageName(entity.getImageName())) {
            isValid = false;
        }
        if (!ProcedureValidator.isValidPrice(entity.getPrice())) {
            isValid = false;
        }
        if (!ProcedureValidator.isValidDescription(entity.getDescription())) {
            isValid = false;
        }

        return isValid;
    }
}
