package by.guzypaul.medicinecentre.dao.impl;

import by.guzypaul.medicinecentre.dao.DaoException;
import by.guzypaul.medicinecentre.dao.connection.ConnectionPool;
import by.guzypaul.medicinecentre.dao.connection.ConnectionPoolException;
import by.guzypaul.medicinecentre.dao.interfaces.ProcedureDao;
import by.guzypaul.medicinecentre.dao.mapper.DaoProcedureMapper;
import by.guzypaul.medicinecentre.entity.Procedure;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProcedureDaoImpl implements ProcedureDao {
    private static final String READ_ALL_PROCEDURE_SQL = "SELECT procedures.id AS procedure_id, " +
            "procedures.name AS procedure_name, procedures.description, procedures.duration, procedures.price, " +
            "procedures.image_name FROM procedures";
    private static final String READ_PROCEDURE_BY_ID_SQL = "SELECT procedures.id AS procedure_id, " +
            "procedures.name AS procedure_name, procedures.description, procedures.duration, procedures.price, " +
            "procedures.image_name FROM procedures WHERE procedures.id = ?";
    private static final String DELETE_PROCEDURE_BY_ID_SQL = "DELETE FROM procedures WHERE procedures.id = ?";
    private static final String CREATE_PROCEDURE_BY_ID_SQL = "INSERT INTO procedures (procedures.name," +
            " procedures.description, procedures.duration, procedures.price, procedures.image_name) " +
            "VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE_PROCEDURE_BY_ID_SQL = "UPDATE procedures SET name = ?," +
            " description = ?, duration = ?, price = ?, image_name = ? " +
            "WHERE procedures.id = ?";
    private final DaoProcedureMapper daoProcedureMapper = new DaoProcedureMapper();

    @Override
    public List<Procedure> readAll() throws DaoException {
        try (Connection connection = ConnectionPool.getInstance().acquireConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(READ_ALL_PROCEDURE_SQL);
            List<Procedure> procedureList = new ArrayList<>();
            while (resultSet.next()) {
                procedureList.add(daoProcedureMapper.mapProcedure(resultSet));
            }

            return procedureList;
        } catch (SQLException | ConnectionPoolException throwables) {
            throw new DaoException(throwables.getMessage());
        }
    }

    @Override
    public Procedure readById(Integer id) throws DaoException {
        try (Connection connection = ConnectionPool.getInstance().acquireConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(READ_PROCEDURE_BY_ID_SQL)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return daoProcedureMapper.mapProcedure(resultSet);

        } catch (SQLException | ConnectionPoolException throwables) {
            throw new DaoException(throwables.getMessage());
        }
    }

    @Override
    public boolean deleteById(Integer id) throws DaoException {
        try (Connection connection = ConnectionPool.getInstance().acquireConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PROCEDURE_BY_ID_SQL)) {
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException | ConnectionPoolException throwables) {
            throw new DaoException(throwables.getMessage());
        }
    }

    @Override
    public boolean create(Procedure entity) throws DaoException {
        try (Connection connection = ConnectionPool.getInstance().acquireConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_PROCEDURE_BY_ID_SQL)) {
            fillProcedureData(entity, preparedStatement);
            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException | ConnectionPoolException throwables) {
            throw new DaoException(throwables.getMessage());
        }
    }

    @Override
    public boolean update(Procedure entity) throws DaoException {
        try (Connection connection = ConnectionPool.getInstance().acquireConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PROCEDURE_BY_ID_SQL)) {
            fillProcedureData(entity, preparedStatement);
            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException | ConnectionPoolException throwables) {
            throw new DaoException(throwables.getMessage());
        }
    }

    private void fillProcedureData(Procedure entity, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, entity.getName());
        preparedStatement.setString(2, entity.getDescription());
        preparedStatement.setInt(3, (int) entity.getDuration().toMinutes());
        preparedStatement.setBigDecimal(4, entity.getPrice());
        preparedStatement.setString(5, entity.getImageName());
        preparedStatement.setInt(6, entity.getId());
    }
}
