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
import java.util.Optional;

/**
 * The type Doctor schedule dao.
 * @author Guziy Paul
 * @see DoctorScheduleDao
 */
public class DoctorScheduleDaoImpl implements DoctorScheduleDao {
    private static final String READ_ALL_DOCTOR_SCHEDULE_SQL = "SELECT doctor_schedules.id AS doctor_schedules_id, " +
            "doctor_schedules.start_time, doctor_schedules.end_time, " +
            "doctor_schedules.info, doctors.id AS doctor_id, doctors.qualification, doctors.rank, doctors.photo_name, " +
            "users.id AS user_id, users.name AS user_name, users.surname, users.password, users.email, users.phone, users.role " +
            "FROM doctor_schedules INNER JOIN doctors ON doctor_schedules.doctor_id = doctors.id INNER JOIN " +
            "users ON doctors.doctor_info = users.id";

    private static final String READ_DOCTOR_SCHEDULE_BY_ID_SQL = "SELECT doctor_schedules.id AS doctor_schedules_id, " +
            "doctor_schedules.start_time, doctor_schedules.end_time," +
            "doctor_schedules.info, doctors.id AS doctor_id, doctors.qualification, doctors.rank, doctors.photo_name, " +
            "users.id AS user_id, users.name AS user_name, users.surname, users.password, users.email, users.phone, users.role " +
            "FROM doctor_schedules INNER JOIN doctors ON doctor_schedules.doctor_id = doctors.id INNER JOIN " +
            "users ON doctors.doctor_info = users.id WHERE doctor_schedules.id = ? ";
    private static final String READ_DOCTOR_SCHEDULE_BY_DOCTOR_ID_SQL = "SELECT doctor_schedules.id AS doctor_schedules_id, " +
            "doctor_schedules.start_time, doctor_schedules.end_time, " +
            "doctor_schedules.info, doctors.id AS doctor_id, doctors.qualification, doctors.rank, doctors.photo_name, " +
            "users.id AS user_id, users.name AS user_name, users.surname, users.password, users.email, users.phone, users.role " +
            "FROM doctor_schedules INNER JOIN doctors ON doctor_schedules.doctor_id = doctors.id INNER JOIN " +
            "users ON doctors.doctor_info = users.id WHERE doctors.id = ? ";
    private static final String DELETE_DOCTOR_SCHEDULE_BY_ID_SQL = "DELETE FROM doctor_schedules " +
            "WHERE doctor_schedules.id = ?";
    private static final String CREATE_DOCTOR_SCHEDULE_BY_ID_SQL = "INSERT INTO doctor_schedules " +
            "(doctor_schedules.doctor_id, doctor_schedules.start_time, doctor_schedules.end_time, " +
            "doctor_schedules.info) " + "VALUES (?, ?, ?, ?)";
    private static final String UPDATE_DOCTOR_SCHEDULE_BY_ID_SQL = "UPDATE doctor_schedules SET " +
            "start_time = ?, end_time = ?, info = ? WHERE doctor_schedules.id = ?";

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
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException(e.getMessage());
        }
    }

    @Override
    public Optional<DoctorSchedule> readById(Integer id) throws DaoException {
        return readBySomeId(id, READ_DOCTOR_SCHEDULE_BY_ID_SQL);
    }

    @Override
    public Optional<DoctorSchedule> readByDoctorId(Integer doctorId) throws DaoException {
        return readBySomeId(doctorId, READ_DOCTOR_SCHEDULE_BY_DOCTOR_ID_SQL);
    }

    @Override
    public boolean deleteById(Integer id) throws DaoException {
        try (Connection connection = ConnectionPool.getInstance().acquireConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_DOCTOR_SCHEDULE_BY_ID_SQL)) {
            preparedStatement.setInt(1, id);

            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException(e.getMessage());
        }
    }

    @Override
    public boolean create(DoctorSchedule entity) throws DaoException {
        try (Connection connection = ConnectionPool.getInstance().acquireConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_DOCTOR_SCHEDULE_BY_ID_SQL)) {
            preparedStatement.setInt(1, entity.getDoctor().getId());
            preparedStatement.setTime(2, entity.getStartTime());
            preparedStatement.setTime(3, entity.getEndTime());
            preparedStatement.setString(4, entity.getInfo());

            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException(e.getMessage());
        }
    }

    @Override
    public boolean update(DoctorSchedule entity) throws DaoException {
        try (Connection connection = ConnectionPool.getInstance().acquireConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_DOCTOR_SCHEDULE_BY_ID_SQL)) {
            preparedStatement.setTime(1, entity.getStartTime());
            preparedStatement.setTime(2, entity.getEndTime());
            preparedStatement.setString(3, entity.getInfo());
            preparedStatement.setInt(4, entity.getId());

            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException(e.getMessage());
        }
    }

    private Optional<DoctorSchedule> readBySomeId(Integer someId, String SQL) throws DaoException {
        try (Connection connection = ConnectionPool.getInstance().acquireConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
            preparedStatement.setInt(1, someId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return Optional.of(daoDoctorScheduleMapper.mapDoctorSchedule(resultSet));
            }

            return Optional.empty();
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException(e.getMessage());
        }
    }
}
