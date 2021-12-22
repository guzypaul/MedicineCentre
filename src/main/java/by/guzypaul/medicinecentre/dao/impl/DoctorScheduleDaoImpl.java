package by.guzypaul.medicinecentre.dao.impl;

import by.guzypaul.medicinecentre.dao.DaoException;
import by.guzypaul.medicinecentre.dao.connection.ConnectionPool;
import by.guzypaul.medicinecentre.dao.connection.ConnectionPoolException;
import by.guzypaul.medicinecentre.dao.interfaces.DoctorScheduleDao;
import by.guzypaul.medicinecentre.dao.mapper.DaoDoctorScheduleMapper;
import by.guzypaul.medicinecentre.entity.DoctorSchedule;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorScheduleDaoImpl implements DoctorScheduleDao {
    private static final String READ_ALL_DOCTOR_SCHEDULE_SQL = "SELECT doctor_schedules.id AS doctor_schedules_id, " +
            "doctor_schedules.start_time, doctor_schedules.end_time, " +
            "doctor_schedules.info, doctors.id AS doctor_id, doctors.qualification, doctors.rank, " +
            "users.id AS user_id, users.name, users.surname, users.password, users.email, users.phone, users.role " +
            "FROM doctor_schedules INNER JOIN doctors ON doctor_schedules.doctor_id = doctors.id INNER JOIN " +
            "users ON doctors.doctor_info = users.id";

    private static final String READ_DOCTOR_SCHEDULE_BY_ID_SQL = "SELECT doctor_schedules.id AS doctor_schedules_id, " +
            "doctor_schedules.start_time, doctor_schedules.end_time," +
            "doctor_schedules.info, doctors.id AS doctor_id, doctors.qualification, doctors.rank, " +
            "users.id AS user_id, users.name, users.surname, users.password, users.email, users.phone, users.role " +
            "FROM doctor_schedules INNER JOIN doctors ON doctor_schedules.doctor_id = doctors.id INNER JOIN " +
            "users ON doctors.doctor_info = users.id WHERE doctor_schedules.id = ? ";
    private static final String DELETE_DOCTOR_SCHEDULE_BY_ID_SQL = "DELETE FROM doctor_schedules " +
            "WHERE doctor_schedules.id = ?";
    private static final String CREATE_DOCTOR_SCHEDULE_BY_ID_SQL = "INSERT INTO doctor_schedules " +
            "(doctor_schedules.doctor_id, doctor_schedules.start_time, doctor_schedules.end_time, " +
            "doctor_schedules.info) " + "VALUES (?, ?, ?, ?)";
    private static final String UPDATE_DOCTOR_SCHEDULE_BY_ID_SQL = "UPDATE doctor_schedules SET doctor_id = ?," +
            " start_time = ?, end_time = ?, info = ? WHERE doctor_schedules.id = ?";

    private final DaoDoctorScheduleMapper daoDoctorScheduleMapper = new DaoDoctorScheduleMapper();

    @Override
    public List<DoctorSchedule> readAll() throws DaoException {
        try (Connection connection = ConnectionPool.getInstance().acquireConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(READ_ALL_DOCTOR_SCHEDULE_SQL);
            List<DoctorSchedule> doctorScheduleList = new ArrayList<>();
            while (resultSet.next()) {
                doctorScheduleList.add(daoDoctorScheduleMapper.mapDoctorSchedule(resultSet));
            }

            return doctorScheduleList;
        } catch (SQLException | ConnectionPoolException throwables) {
            throw new DaoException(throwables.getMessage());
        }
    }

    @Override
    public DoctorSchedule readById(Integer id) throws DaoException {
        try (Connection connection = ConnectionPool.getInstance().acquireConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(READ_DOCTOR_SCHEDULE_BY_ID_SQL)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            return daoDoctorScheduleMapper.mapDoctorSchedule(resultSet);
        } catch (SQLException | ConnectionPoolException throwables) {
            throw new DaoException(throwables.getMessage());
        }
    }

    @Override
    public boolean deleteById(Integer id) throws DaoException {
        try (Connection connection = ConnectionPool.getInstance().acquireConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_DOCTOR_SCHEDULE_BY_ID_SQL)) {
            preparedStatement.setInt(1, id);

            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException | ConnectionPoolException throwables) {
            throw new DaoException(throwables.getMessage());
        }
    }

    @Override
    public boolean create(DoctorSchedule entity) throws DaoException {
        try (Connection connection = ConnectionPool.getInstance().acquireConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_DOCTOR_SCHEDULE_BY_ID_SQL)) {
            fillDoctorScheduleData(entity, preparedStatement);

            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException | ConnectionPoolException throwables) {
            throw new DaoException(throwables.getMessage());
        }
    }

    @Override
    public boolean update(DoctorSchedule entity) throws DaoException {
        try (Connection connection = ConnectionPool.getInstance().acquireConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_DOCTOR_SCHEDULE_BY_ID_SQL)) {
            fillDoctorScheduleData(entity, preparedStatement);
            preparedStatement.setInt(5, entity.getId());

            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException | ConnectionPoolException throwables) {
            throw new DaoException(throwables.getMessage());
        }
    }

    private void fillDoctorScheduleData(DoctorSchedule entity, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1, entity.getDoctor().getId());
        preparedStatement.setTime(2, entity.getStartTime());
        preparedStatement.setTime(3, entity.getEndTime());
        preparedStatement.setString(4, entity.getInfo());
    }
}
