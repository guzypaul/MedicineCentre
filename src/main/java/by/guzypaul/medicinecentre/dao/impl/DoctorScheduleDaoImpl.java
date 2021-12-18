package by.guzypaul.medicinecentre.dao.impl;

import by.guzypaul.medicinecentre.dao.exception.DaoException;
import by.guzypaul.medicinecentre.dao.interfaces.DoctorScheduleDao;
import by.guzypaul.medicinecentre.dao.mapper.DaoDoctorScheduleMapper;
import by.guzypaul.medicinecentre.entity.DoctorSchedule;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorScheduleDaoImpl implements DoctorScheduleDao {
    private static final String READ_ALL_DOCTOR_SCHEDULE_SQL = "SELECT doctor_schedules.id, " +
            "doctor_schedules.doctor_id, doctor_schedules.start_time, doctor_schedules.end_time, " +
            "doctor_schedules.info FROM doctor_schedules";
    private static final String READ_DOCTOR_SCHEDULE_BY_ID_SQL = "SELECT doctor_schedules.id, " +
            "doctor_schedules.doctor_id, doctor_schedules.start_time, doctor_schedules.end_time, " +
            "doctor_schedules.info FROM doctor_schedules WHERE doctor_schedules.id = ?";
    private static final String DELETE_DOCTOR_SCHEDULE_BY_ID_SQL = "DELETE FROM doctor_schedules " +
            "WHERE doctor_schedules.id = ?";
    private static final String CREATE_DOCTOR_SCHEDULE_BY_ID_SQL = "INSERT INTO doctor_schedules " +
            "(doctor_schedules.doctor_id, doctor_schedules.start_time, doctor_schedules.end_time, " +
            "doctor_schedules.info) " + "VALUES (?, ?, ?, ?)";
    private static final String UPDATE_DOCTOR_SCHEDULE_BY_ID_SQL = "UPDATE doctor_schedules SET doctor_id = ?," +
            " start_time = ?, end_time = ?, info = ? WHERE doctor_schedules.id = ?";

    private final DaoDoctorScheduleMapper daoDoctorScheduleMapper = new DaoDoctorScheduleMapper();
    private Connection connection;

    @Override
    public List<DoctorSchedule> readAll() throws DaoException {
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(READ_ALL_DOCTOR_SCHEDULE_SQL);
            List<DoctorSchedule> doctorScheduleList = new ArrayList<>();
            while (resultSet.next()) {
                doctorScheduleList.add(daoDoctorScheduleMapper.mapDoctorSchedule(resultSet));
            }

            return doctorScheduleList;
        } catch (SQLException throwables) {
            throw new DaoException(throwables.getMessage());
        }
    }

    @Override
    public DoctorSchedule readById(Integer id) throws DaoException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(READ_DOCTOR_SCHEDULE_BY_ID_SQL)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return daoDoctorScheduleMapper.mapDoctorSchedule(resultSet);

        } catch (SQLException throwables) {
            throw new DaoException(throwables.getMessage());
        }
    }

    @Override
    public boolean deleteById(Integer id) throws DaoException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_DOCTOR_SCHEDULE_BY_ID_SQL)) {
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException throwables) {
            throw new DaoException(throwables.getMessage());
        }
    }

    @Override
    public boolean create(DoctorSchedule entity) throws DaoException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(CREATE_DOCTOR_SCHEDULE_BY_ID_SQL)) {
            setDoctorScheduleEntity(entity, preparedStatement);
            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException throwables) {
            throw new DaoException(throwables.getMessage());
        }
    }

    @Override
    public boolean update(DoctorSchedule entity) throws DaoException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_DOCTOR_SCHEDULE_BY_ID_SQL)) {
            setDoctorScheduleEntity(entity, preparedStatement);
            preparedStatement.setInt(5, entity.getId());
            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException throwables) {
            throw new DaoException(throwables.getMessage());
        }
    }

    private void setDoctorScheduleEntity(DoctorSchedule entity, PreparedStatement preparedStatement) throws SQLException { //todo change method's name
        //preparedStatement.setInt(1, entity.getDoctorId()); //todo
        preparedStatement.setTime(2, entity.getStartTime());
        preparedStatement.setTime(3, entity.getEndTime());
        preparedStatement.setString(4, entity.getInfo());
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
