package by.guzypaul.medicinecentre.dao.impl;

import by.guzypaul.medicinecentre.dao.DaoException;
import by.guzypaul.medicinecentre.dao.connection.ConnectionPool;
import by.guzypaul.medicinecentre.dao.connection.ConnectionPoolException;
import by.guzypaul.medicinecentre.dao.interfaces.DoctorDao;
import by.guzypaul.medicinecentre.dao.mapper.DaoDoctorMapper;
import by.guzypaul.medicinecentre.entity.Doctor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DoctorDaoImpl implements DoctorDao {
    private static final String READ_ALL_DOCTOR_SQL = "SELECT doctors.id AS doctor_id, doctors.qualification, " +
            "doctors.rank, doctors.photo_name, " +
            "users.id AS user_id, users.name AS user_name, users.surname, users.password, users.email, users.phone, " +
            "users.role " +
            "FROM doctors INNER JOIN users ON doctors.doctor_info = users.id";
    private static final String READ_DOCTOR_BY_ID_SQL = "SELECT doctors.id AS doctor_id, doctors.qualification, " +
            "doctors.rank, doctors.photo_name, " +
            "users.id AS user_id, users.name AS user_name, users.surname, users.password, users.email, users.phone, " +
            "users.role FROM doctors INNER JOIN users ON doctors.doctor_info = users.id WHERE doctors.id = ?";
    private static final String READ_DOCTOR_BY_USER_ID_SQL = "SELECT doctors.id AS doctor_id, doctors.qualification, " +
            "doctors.rank, doctors.photo_name, " +
            "users.id AS user_id, users.name AS user_name, users.surname, users.password, users.email, users.phone, " +
            "users.role FROM doctors INNER JOIN users ON doctors.doctor_info = users.id WHERE users.id = ?";
    private static final String DELETE_DOCTOR_BY_ID_SQL = "DELETE FROM doctors WHERE doctors.id = ?";
    private static final String CREATE_DOCTOR_BY_ID_SQL = "INSERT INTO doctors (doctors.qualification, " +
            "doctors.rank, doctors.doctor_info, doctors.photo_name) VALUES (?, ?, ?, ?)";
    private static final String UPDATE_DOCTOR_BY_ID_SQL = "UPDATE doctors SET doctors.qualification = ?," +
            " doctors.rank = ?, doctors.photo_name = ? WHERE doctors.id = ?";

    private final DaoDoctorMapper daoDoctorMapper = new DaoDoctorMapper();

    @Override
    public List<Doctor> readAll() throws DaoException {
        try (Connection connection = ConnectionPool.getInstance().acquireConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(READ_ALL_DOCTOR_SQL);
            List<Doctor> doctorList = new ArrayList<>();
            while (resultSet.next()) {
                doctorList.add(daoDoctorMapper.mapDoctor(resultSet));
            }

            return doctorList;
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException(e.getMessage());
        }
    }

    @Override
    public Optional<Doctor> readById(Integer id) throws DaoException {
        return readBySomeId(id, READ_DOCTOR_BY_ID_SQL);
    }

    @Override
    public Optional<Doctor> readByUserId(Integer userId) throws DaoException {
        return readBySomeId(userId, READ_DOCTOR_BY_USER_ID_SQL);
    }

    @Override
    public boolean deleteById(Integer id) throws DaoException {
        try (Connection connection = ConnectionPool.getInstance().acquireConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_DOCTOR_BY_ID_SQL)) {
            preparedStatement.setInt(1, id);

            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException(e.getMessage());
        }
    }

    @Override
    public boolean create(Doctor entity) throws DaoException {
        try (Connection connection = ConnectionPool.getInstance().acquireConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_DOCTOR_BY_ID_SQL)) {
            preparedStatement.setString(1, entity.getQualification());
            preparedStatement.setString(2, entity.getRank());
            preparedStatement.setInt(3, entity.getDoctorInfo().getId());
            preparedStatement.setString(4, entity.getPhotoName());

            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException(e.getMessage());
        }
    }

    @Override
    public boolean update(Doctor entity) throws DaoException {
        try (Connection connection = ConnectionPool.getInstance().acquireConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_DOCTOR_BY_ID_SQL)) {
            preparedStatement.setString(1, entity.getQualification());
            preparedStatement.setString(2, entity.getRank());
            preparedStatement.setString(3, entity.getPhotoName());
            preparedStatement.setInt(4, entity.getId());

            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException(e.getMessage());
        }
    }

    private Optional<Doctor> readBySomeId(Integer someId, String SQL) throws DaoException {
        try (Connection connection = ConnectionPool.getInstance().acquireConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
            preparedStatement.setInt(1, someId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return Optional.of(daoDoctorMapper.mapDoctor(resultSet));
            }

            return Optional.empty();
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException(e.getMessage());
        }
    }
}
