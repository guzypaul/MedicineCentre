package by.guzypaul.medicinecentre.dao.mapper;

import by.guzypaul.medicinecentre.entity.Doctor;
import by.guzypaul.medicinecentre.entity.Procedure;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoDoctorMapper {
    public Doctor mapDoctor (ResultSet resultSet) throws SQLException {
        Procedure procedure = new Procedure();
        Doctor doctor = new Doctor();
        doctor.setId(resultSet.getInt("id"));
        doctor.setQualification(resultSet.getString("qualification"));
        doctor.setRank(resultSet.getString("rank"));
        doctor.setDoctorInfo(resultSet.getInt("doctor_info"));

        return doctor;
    }
}
