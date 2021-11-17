package by.guzypaul.medicinecentre.dao.impl;

import by.guzypaul.medicinecentre.dao.DaoException;
import by.guzypaul.medicinecentre.dao.DaoMapper;
import by.guzypaul.medicinecentre.dao.ProcedureDao;
import by.guzypaul.medicinecentre.entity.Procedure;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProcedureDaoImpl implements ProcedureDao {
    private static final String READ_PROCEDURE_BY_ID_SQL = "SELECT procedures.id, procedures.name, " +
            "procedures.description, procedures.duration, procedures.price, " +
            "procedures.image_name FROM procedures WHERE procedures.id = ?";
    private final DaoMapper daoMapper = new DaoMapper();
    private Connection connection;

    @Override
    public List<Procedure> readAll() {
        return null;
    }

    @Override
    public Procedure readById(Integer id) throws DaoException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(READ_PROCEDURE_BY_ID_SQL)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                return daoMapper.mapProcedure(resultSet);
            }
        } catch (SQLException throwables) {
            throw new DaoException(throwables.getMessage());
        }
        return null;
    }

    @Override
    public boolean deleteById(Integer id) {
        return false;
    }

    @Override
    public boolean create(Procedure entity) {
        return false;
    }

    @Override
    public boolean update(Procedure entity) {
        return false;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
