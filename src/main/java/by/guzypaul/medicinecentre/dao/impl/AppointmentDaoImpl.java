package by.guzypaul.medicinecentre.dao.impl;

import by.guzypaul.medicinecentre.dao.DaoException;
import by.guzypaul.medicinecentre.dao.connection.ConnectionPool;
import by.guzypaul.medicinecentre.dao.connection.ConnectionPoolException;
import by.guzypaul.medicinecentre.dao.AppointmentDao;
import by.guzypaul.medicinecentre.dao.mapper.DaoAppointmentMapper;
import by.guzypaul.medicinecentre.entity.Appointment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The type Appointment dao.
 * @author Guziy Paul
 * @see AppointmentDao
 */
public class AppointmentDaoImpl implements AppointmentDao {
    private static final String READ_ALL_APPOINTMENT_SQL = "SELECT appointments.id AS appointment_id, " +
            "appointments.date, appointments.start_time, appointments.end_time, appointments.status, " +
            "procedures.id AS procedure_id, procedures.name AS procedure_name, procedures.description, " +
            "procedures.duration, procedures.price, procedures.image_name, procedures.doctor_qualification, " +
            "doctors.id AS doctor_id, doctors.qualification, doctors.rank, doctors.photo_name, " +
            "users.id AS user_id, users.name AS user_name, users.surname, users.password, users.email, users.phone, " +
            "users.role, " +
            "client.id AS client_id, client.name AS client_name, client.surname AS client_surname, " +
            "client.password AS client_password, client.email AS client_email, client.phone AS client_phone, " +
            "client.role AS client_role " +
            "FROM appointments INNER JOIN procedures ON appointments.procedure_id = procedures.id " +
            "INNER JOIN doctors ON appointments.doctor_id = doctors.id " +
            "INNER JOIN users ON doctors.doctor_info = users.id " +
            "INNER JOIN users AS client ON appointments.client_id = client.id";

    private static final String READ_APPOINTMENT_BY_ID_SQL = "SELECT appointments.id AS appointment_id, " +
            "appointments.date, appointments.start_time, appointments.end_time, appointments.status, " +
            "procedures.id AS procedure_id, procedures.name AS procedure_name, procedures.description, " +
            "procedures.duration, procedures.price, procedures.image_name, procedures.doctor_qualification, " +
            "doctors.id AS doctor_id, doctors.qualification, doctors.rank, doctors.photo_name, " +
            "users.id AS user_id, users.name AS user_name, users.surname, users.password, users.email, users.phone, " +
            "users.role, " +
            "client.id AS client_id, client.name AS client_name, client.surname AS client_surname, " +
            "client.password AS client_password, client.email AS client_email, client.phone AS client_phone, " +
            "client.role AS client_role " +
            "FROM appointments INNER JOIN procedures ON appointments.procedure_id = procedures.id " +
            "INNER JOIN doctors ON appointments.doctor_id = doctors.id " +
            "INNER JOIN users ON doctors.doctor_info = users.id " +
            "INNER JOIN users AS client ON appointments.client_id = client.id WHERE appointments.id = ?";
    private static final String READ_APPOINTMENT_BY_DOCTOR_ID_SQL = "SELECT appointments.id AS appointment_id, " +
            "appointments.date, appointments.start_time, appointments.end_time, appointments.status, " +
            "procedures.id AS procedure_id, procedures.name AS procedure_name, procedures.description, " +
            "procedures.duration, procedures.price, procedures.image_name, procedures.doctor_qualification, " +
            "doctors.id AS doctor_id, doctors.qualification, doctors.rank, doctors.photo_name, " +
            "users.id AS user_id, users.name AS user_name, users.surname, users.password, users.email, users.phone, " +
            "users.role, " +
            "client.id AS client_id, client.name AS client_name, client.surname AS client_surname, " +
            "client.password AS client_password, client.email AS client_email, client.phone AS client_phone, " +
            "client.role AS client_role " +
            "FROM appointments INNER JOIN procedures ON appointments.procedure_id = procedures.id " +
            "INNER JOIN doctors ON appointments.doctor_id = doctors.id " +
            "INNER JOIN users ON doctors.doctor_info = users.id " +
            "INNER JOIN users AS client ON appointments.client_id = client.id WHERE doctors.id = ?";
    private static final String READ_APPOINTMENT_BY_CLIENT_ID_SQL = "SELECT appointments.id AS appointment_id, " +
            "appointments.date, appointments.start_time, appointments.end_time, appointments.status, " +
            "procedures.id AS procedure_id, procedures.name AS procedure_name, procedures.description, " +
            "procedures.duration, procedures.price, procedures.image_name, procedures.doctor_qualification, " +
            "doctors.id AS doctor_id, doctors.qualification, doctors.rank, doctors.photo_name, " +
            "users.id AS user_id, users.name AS user_name, users.surname, users.password, users.email, users.phone, " +
            "users.role, " +
            "client.id AS client_id, client.name AS client_name, client.surname AS client_surname, " +
            "client.password AS client_password, client.email AS client_email, client.phone AS client_phone, " +
            "client.role AS client_role " +
            "FROM appointments INNER JOIN procedures ON appointments.procedure_id = procedures.id " +
            "INNER JOIN doctors ON appointments.doctor_id = doctors.id " +
            "INNER JOIN users ON doctors.doctor_info = users.id " +
            "INNER JOIN users AS client ON appointments.client_id = client.id WHERE client.id = ?";
    private static final String DELETE_APPOINTMENT_BY_ID_SQL = "DELETE FROM appointments WHERE appointments.id = ?";
    private static final String CREATE_APPOINTMENT_BY_ID_SQL = "INSERT INTO appointments (appointments.client_id, " +
            "appointments.doctor_id, appointments.date, appointments.start_time, appointments.end_time," +
            "appointments.procedure_id, appointments.status) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_APPOINTMENT_BY_ID_SQL = "UPDATE appointments SET appointments.client_id = ?," +
            "appointments.doctor_id = ?, appointments.date = ?, appointments.start_time = ?, " +
            "appointments.end_time = ?, appointments.procedure_id = ?, appointments.status = ? " +
            "WHERE appointments.id = ?";

    private final DaoAppointmentMapper daoAppointmentMapper = new DaoAppointmentMapper();

    @Override
    public List<Appointment> readAll() throws DaoException {
        try (Connection connection = ConnectionPool.getInstance().acquireConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(READ_ALL_APPOINTMENT_SQL);
            List<Appointment> appointmentList = new ArrayList<>();
            while (resultSet.next()) {
                appointmentList.add(daoAppointmentMapper.mapAppointment(resultSet));
            }

            return appointmentList;
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException(e.getMessage());
        }
    }

    @Override
    public List<Appointment> readByDoctorId(Integer doctorId) throws DaoException {
        return readBySomeId(doctorId, READ_APPOINTMENT_BY_DOCTOR_ID_SQL);
    }

    @Override
    public List<Appointment> readByClientId(Integer clientId) throws DaoException {
        return readBySomeId(clientId, READ_APPOINTMENT_BY_CLIENT_ID_SQL);
    }

    @Override
    public Optional<Appointment> readById(Integer id) throws DaoException {
        try (Connection connection = ConnectionPool.getInstance().acquireConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(READ_APPOINTMENT_BY_ID_SQL)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return Optional.of(daoAppointmentMapper.mapAppointment(resultSet));
            }

            return Optional.empty();
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException(e.getMessage());
        }
    }

    @Override
    public boolean deleteById(Integer id) throws DaoException {
        try (Connection connection = ConnectionPool.getInstance().acquireConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_APPOINTMENT_BY_ID_SQL)) {
            preparedStatement.setInt(1, id);

            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException(e.getMessage());
        }
    }

    @Override
    public boolean create(Appointment entity) throws DaoException {
        try (Connection connection = ConnectionPool.getInstance().acquireConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_APPOINTMENT_BY_ID_SQL)) {
            fillAppointmentData(entity, preparedStatement);

            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException(e.getMessage());
        }
    }

    @Override
    public boolean update(Appointment entity) throws DaoException {
        try (Connection connection = ConnectionPool.getInstance().acquireConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_APPOINTMENT_BY_ID_SQL)) {
            fillAppointmentData(entity, preparedStatement);
            preparedStatement.setInt(8, entity.getId());

            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException(e.getMessage());
        }
    }

    private List<Appointment> readBySomeId(Integer someId, String SQL) throws DaoException {
        try (Connection connection = ConnectionPool.getInstance().acquireConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
            preparedStatement.setInt(1, someId);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Appointment> appointmentList = new ArrayList<>();
            while (resultSet.next()) {
                appointmentList.add(daoAppointmentMapper.mapAppointment(resultSet));
            }

            return appointmentList;
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException(e.getMessage());
        }
    }

    private void fillAppointmentData(Appointment entity, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1, entity.getUserClient().getId());
        preparedStatement.setInt(2, entity.getDoctor().getId());
        preparedStatement.setDate(3, Date.valueOf(entity.getDate()));
        preparedStatement.setTime(4, entity.getStartTime());
        preparedStatement.setTime(5, entity.getEndTime());
        preparedStatement.setInt(6, entity.getProcedure().getId());
        preparedStatement.setString(7, entity.getStatus().toString());
    }
}
