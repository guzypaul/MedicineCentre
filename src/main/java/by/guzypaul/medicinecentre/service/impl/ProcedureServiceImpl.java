package by.guzypaul.medicinecentre.service.impl;

import by.guzypaul.medicinecentre.dao.DaoException;
import by.guzypaul.medicinecentre.dao.DaoFactory;
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
    private static final String INVALID_PROCEDURE = "Invalid procedure!";
    private final ProcedureDao procedureDao;
    private final ProcedureValidator procedureValidator;

    public ProcedureServiceImpl() {
        this.procedureDao = DaoFactory.getInstance().getProcedureDao();
        this.procedureValidator = new ProcedureValidator();
    }

    @Override
    public List<Procedure> readAll() throws ServiceException {
        logger.log(Level.DEBUG, "readAll()");
        try {
            return procedureDao.readAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Procedure readById(String id) throws ServiceException {
        logger.log(Level.DEBUG, "readById(), procedure id:" + id);
        try {
            return procedureDao.readById(Integer.parseInt(id));
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean deleteById(String id) throws ServiceException {
        logger.log(Level.DEBUG, "deleteById(), procedure id:" + id);
        try {
            return procedureDao.deleteById(Integer.parseInt(id));
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean create(Procedure entity) throws ServiceException {
        logger.log(Level.DEBUG, "create() " + entity);
        try {
            if(procedureValidator.validateProcedure(entity)) {
                return procedureDao.create(entity);
            }

            throw new ServiceException(INVALID_PROCEDURE);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean update(Procedure entity) throws ServiceException {
        logger.log(Level.DEBUG, "update() " + entity);
        try {
            if(procedureValidator.validateProcedure(entity)) {
                return procedureDao.update(entity);
            }
            throw new ServiceException(INVALID_PROCEDURE);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
