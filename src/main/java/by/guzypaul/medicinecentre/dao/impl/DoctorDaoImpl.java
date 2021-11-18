package by.guzypaul.medicinecentre.dao.impl;

import by.guzypaul.medicinecentre.dao.DaoException;
import by.guzypaul.medicinecentre.dao.mapper.DaoDoctorMapper;
import by.guzypaul.medicinecentre.dao.DoctorDao;
import by.guzypaul.medicinecentre.entity.Doctor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDaoImpl implements DoctorDao {
    private static final String READ_ALL_DOCTOR_SQL = "SELECT doctors.id, doctors.qualification, " +
            "doctors.rank, doctors.doctor_info FROM doctors";
    private static final String READ_DOCTOR_BY_ID_SQL = "SELECT doctors.id, doctors.qualification, " +
            "doctors.rank, doctors.doctor_info FROM doctors WHERE doctors.id = ?";
    private static final String DELETE_DOCTOR_BY_ID_SQL = "DELETE FROM doctors WHERE doctors.id = ?";
    private static final String CREATE_DOCTOR_BY_ID_SQL = "INSERT INTO doctors (doctors.qualification, " +
            "doctors.rank, doctors.doctor_info) " + "VALUES (?, ?, ?)";
    private static final String UPDATE_DOCTOR_BY_ID_SQL = "UPDATE doctors SET qualification = ?," +
            " rank = ?, doctor_info = ? WHERE doctors.id = ?";

    private final DaoDoctorMapper daoDoctorMapper = new DaoDoctorMapper();
    private Connection connection;

    @Override
    public List<Doctor> readAll() throws DaoException {
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(READ_ALL_DOCTOR_SQL);
            List<Doctor> doctorList = new ArrayList<>();
            while (resultSet.next()) {
                doctorList.add(daoDoctorMapper.mapDoctor(resultSet));
            }

            return doctorList;
        } catch (SQLException throwables) {
            throw new DaoException(throwables.getMessage());
        }
    }

    @Override
    public Doctor readById(Integer id) throws DaoException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(READ_DOCTOR_BY_ID_SQL)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return daoDoctorMapper.mapDoctor(resultSet);

        } catch (SQLException throwables) {
            throw new DaoException(throwables.getMessage());
        }
    }

    @Override
    public boolean deleteById(Integer id) throws DaoException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_DOCTOR_BY_ID_SQL)) {
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException throwables) {
            throw new DaoException(throwables.getMessage());
        }
    }

    @Override
    public boolean create(Doctor entity) throws DaoException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(CREATE_DOCTOR_BY_ID_SQL)) {
            setDoctorEntity(entity, preparedStatement);
            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException throwables) {
            throw new DaoException(throwables.getMessage());
        }
    }

    @Override
    public boolean update(Doctor entity) throws DaoException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_DOCTOR_BY_ID_SQL)) {
            setDoctorEntity(entity, preparedStatement);
            preparedStatement.setInt(4, entity.getId());
            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException throwables) {
            throw new DaoException(throwables.getMessage());
        }
    }

    private void setDoctorEntity(Doctor entity, PreparedStatement preparedStatement) throws SQLException { //todo change method's name
        preparedStatement.setString(1, entity.getQualification());
        preparedStatement.setString(2, entity.getRank());
        preparedStatement.setInt(3, entity.getDoctorInfo());
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
