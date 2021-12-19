package by.guzypaul.medicinecentre.dao.mapper;

import by.guzypaul.medicinecentre.entity.DoctorSchedule;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoDoctorScheduleMapper {
    public DoctorSchedule mapDoctorSchedule (ResultSet resultSet) throws SQLException {
        DoctorSchedule doctorSchedule = new DoctorSchedule();
        DaoDoctorMapper daoDoctorMapper = new DaoDoctorMapper();

        doctorSchedule.setId(resultSet.getInt("doctor_schedules_id"));
        doctorSchedule.setDoctor(daoDoctorMapper.mapDoctor(resultSet));
        doctorSchedule.setStartTime(resultSet.getTime("start_time"));
        doctorSchedule.setEndTime(resultSet.getTime("end_time"));
        doctorSchedule.setInfo(resultSet.getString("info"));

        return doctorSchedule;
    }
}
