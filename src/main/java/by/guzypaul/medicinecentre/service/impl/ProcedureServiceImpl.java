package by.guzypaul.medicinecentre.service.impl;

import by.guzypaul.medicinecentre.dao.DaoException;
import by.guzypaul.medicinecentre.dao.DaoFactory;
import by.guzypaul.medicinecentre.dao.ProcedureDao;
import by.guzypaul.medicinecentre.entity.Procedure;
import by.guzypaul.medicinecentre.service.exception.ServiceException;
import by.guzypaul.medicinecentre.service.ProcedureService;
import by.guzypaul.medicinecentre.service.validator.ProcedureValidator;

import java.util.List;
import java.util.Optional;

/**
 * The type Procedure service.
 * @author Guziy Paul
 * @see ProcedureService
 */
public class ProcedureServiceImpl implements ProcedureService {
    private static final String INVALID_PROCEDURE = "Invalid procedure!";
    private final ProcedureDao procedureDao;
    private final ProcedureValidator procedureValidator;

    /**
     * Instantiates a new Procedure service.
     */
    public ProcedureServiceImpl() {
        procedureDao = DaoFactory.getInstance().getProcedureDao();
        procedureValidator = new ProcedureValidator();
    }

    @Override
    public List<Procedure> readAll() throws ServiceException {
        try {
            return procedureDao.readAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Optional<Procedure> readById(String id) throws ServiceException {
        try {
            return procedureDao.readById(Integer.parseInt(id));
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean deleteById(String id) throws ServiceException {
        try {
            return procedureDao.deleteById(Integer.parseInt(id));
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean create(Procedure entity) throws ServiceException {
        try {
            if (procedureValidator.validateProcedure(entity)) {
                return procedureDao.create(entity);
            }
            throw new ServiceException(INVALID_PROCEDURE);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean update(Procedure entity) throws ServiceException {
        try {
            if (procedureValidator.validateProcedure(entity)) {
                return procedureDao.update(entity);
            }
            throw new ServiceException(INVALID_PROCEDURE);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
