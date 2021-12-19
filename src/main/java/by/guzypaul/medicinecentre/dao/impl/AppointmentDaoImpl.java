package by.guzypaul.medicinecentre.dao.impl;

import by.guzypaul.medicinecentre.dao.interfaces.AppointmentDao;
import by.guzypaul.medicinecentre.dao.exception.DaoException;
import by.guzypaul.medicinecentre.dao.mapper.DaoAppointmentMapper;
import by.guzypaul.medicinecentre.entity.Appointment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDaoImpl implements AppointmentDao {
    private static final String READ_ALL_APPOINTMENT_SQL = "SELECT appointments.id AS appointment_id, " +
            "appointments.client_id, appointments.doctor_id, appointments.date, appointments.start_time, " +
            "appointments.end_time, appointments.procedure_id, appointments.status, " +
            "procedures.id AS procedure_id, procedures.name, procedures.description, procedures.duration, " +
            "procedures.price, procedures.image_name, " +
            "doctors.id AS doctor_id, doctors.qualification, doctors.rank, " +
            "users.id AS user_id, users.name, users.surname, users.password, users.email, users.phone, users.role " +
            "FROM appointments INNER JOIN procedures ON appointments.procedure_id = procedures.id " +
            "INNER JOIN doctors ON appointments.doctor_id = doctors.id " +
            "INNER JOIN users ON doctors.doctor_info = users.id " +
            "INNER JOIN users ON appointments.client_id = users.id";

    private static final String READ_APPOINTMENT_BY_ID_SQL = "SELECT appointments.id, appointments.client_id, " +
            "appointments.doctor_id, appointments.date, appointments.start_time, appointments.end_time," +
            "appointments.procedure_id, appointments.status FROM appointments WHERE appointments.id = ?";
    private static final String DELETE_APPOINTMENT_BY_ID_SQL = "DELETE FROM appointments WHERE appointments.id = ?";
    private static final String CREATE_APPOINTMENT_BY_ID_SQL = "INSERT INTO appointments (appointments.client_id, " +
            "appointments.doctor_id, appointments.date, appointments.start_time, appointments.end_time," +
            "appointments.procedure_id, appointments.status) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_APPOINTMENT_BY_ID_SQL = "UPDATE appointments SET appointments.client_id = ?," +
            "appointments.doctor_id = ?, appointments.date = ?, appointments.start_time = ?, " +
            "appointments.end_time = ?, appointments.procedure_id = ?, appointments.status = ? " +
            "WHERE appointments.id = ?";

    private final DaoAppointmentMapper daoAppointmentMapper = new DaoAppointmentMapper();
    private Connection connection;

    @Override
    public List<Appointment> readAll() throws DaoException {
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(READ_ALL_APPOINTMENT_SQL);
            List<Appointment> appointmentList = new ArrayList<>();
            while (resultSet.next()) {
                appointmentList.add(daoAppointmentMapper.mapAppointment(resultSet));
            }

            return appointmentList;
        } catch (SQLException throwables) {
            throw new DaoException(throwables.getMessage());
        }
    }

    @Override
    public Appointment readById(Integer id) throws DaoException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(READ_APPOINTMENT_BY_ID_SQL)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return daoAppointmentMapper.mapAppointment(resultSet);

        } catch (SQLException throwables) {
            throw new DaoException(throwables.getMessage());
        }
    }

    @Override
    public boolean deleteById(Integer id) throws DaoException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_APPOINTMENT_BY_ID_SQL)) {
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException throwables) {
            throw new DaoException(throwables.getMessage());
        }
    }

    @Override
    public boolean create(Appointment entity) throws DaoException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(CREATE_APPOINTMENT_BY_ID_SQL)) {
            fillAppointmentData(entity, preparedStatement);
            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException throwables) {
            throw new DaoException(throwables.getMessage());
        }
    }

    @Override
    public boolean update(Appointment entity) throws DaoException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_APPOINTMENT_BY_ID_SQL)) {
            fillAppointmentData(entity, preparedStatement);
            preparedStatement.setInt(8, entity.getId());
            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException throwables) {
            throw new DaoException(throwables.getMessage());
        }
    }

    private void fillAppointmentData(Appointment entity, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1, entity.getUserClient().getId());
        preparedStatement.setInt(2, entity.getDoctor().getId());
        preparedStatement.setDate(3, (Date) entity.getDate());
        preparedStatement.setTime(4, entity.getStartTime());
        preparedStatement.setTime(5, entity.getEndTime());
        preparedStatement.setInt(6, entity.getProcedure().getId());
        preparedStatement.setString(7, entity.getStatus());

    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
