package by.guzypaul.medicinecentre.dao.mapper;

import by.guzypaul.medicinecentre.entity.Doctor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoDoctorMapper {
    public Doctor mapDoctor (ResultSet resultSet) throws SQLException {
        Doctor doctor = new Doctor();
        DaoUserMapper daoUserMapper = new DaoUserMapper();
        doctor.setId(resultSet.getInt("doctor_id"));
        doctor.setQualification(resultSet.getString("qualification"));
        doctor.setRank(resultSet.getString("rank"));
        doctor.setDoctorInfo(daoUserMapper.mapUser(resultSet));

        return doctor;
    }
}
