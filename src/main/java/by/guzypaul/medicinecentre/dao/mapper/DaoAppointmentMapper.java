package by.guzypaul.medicinecentre.dao.mapper;

import by.guzypaul.medicinecentre.entity.Appointment;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoAppointmentMapper {
    public Appointment mapAppointment (ResultSet resultSet) throws SQLException {
        Appointment appointment = new Appointment();
        appointment.setId(resultSet.getInt("id"));
        appointment.setClientId(resultSet.getInt("client_id"));
        appointment.setDoctorId(resultSet.getInt("doctor_id"));
        appointment.setDate(resultSet.getDate("date"));
        appointment.setStartTime(resultSet.getTime("start_time"));
        appointment.setEndTime(resultSet.getTime("end_time"));
        appointment.setProcedureId(resultSet.getInt("procedure_id"));
        appointment.setStatus(resultSet.getString("status"));

        return appointment;
    }
}
