package by.guzypaul.medicinecentre.dao.mapper;

import by.guzypaul.medicinecentre.entity.Appointment;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoAppointmentMapper {
    public Appointment mapAppointment (ResultSet resultSet) throws SQLException {
        Appointment appointment = new Appointment();
        DaoClientMapper daoClientMapper = new DaoClientMapper();
        DaoUserMapper daoUserMapper = new DaoUserMapper();
        DaoDoctorMapper daoDoctorMapper = new DaoDoctorMapper();
        DaoProcedureMapper daoProcedureMapper = new DaoProcedureMapper();

        appointment.setId(resultSet.getInt("appointment_id"));
        appointment.setUserClient(daoClientMapper.mapClient(resultSet));
        appointment.setDoctor(daoDoctorMapper.mapDoctor(resultSet));
        appointment.setDate(resultSet.getDate("date").toLocalDate());
        appointment.setStartTime(resultSet.getTime("start_time"));
        appointment.setEndTime(resultSet.getTime("end_time"));
        appointment.setProcedure(daoProcedureMapper.mapProcedure(resultSet));
        appointment.setStatus(resultSet.getString("status"));

        return appointment;
    }
}
