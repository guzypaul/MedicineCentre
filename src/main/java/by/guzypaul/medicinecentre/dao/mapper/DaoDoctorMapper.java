package by.guzypaul.medicinecentre.dao.mapper;

import by.guzypaul.medicinecentre.entity.Doctor;
import by.guzypaul.medicinecentre.entity.Qualification;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The type Dao doctor mapper.
 * @author Guziy Paul
 */
public class DaoDoctorMapper {
    /**
     * Map doctor doctor.
     *
     * @param resultSet the result set
     * @return the doctor
     * @throws SQLException the sql exception
     */
    public Doctor mapDoctor (ResultSet resultSet) throws SQLException {
        Doctor doctor = new Doctor();
        DaoUserMapper daoUserMapper = new DaoUserMapper();
        doctor.setId(resultSet.getInt("doctor_id"));
        doctor.setQualification(Qualification.findByName(resultSet.getString("qualification")));
        doctor.setRank(resultSet.getString("rank"));
        doctor.setDoctorInfo(daoUserMapper.mapUser(resultSet));
        doctor.setPhotoName(resultSet.getString("photo_name"));

        return doctor;
    }
}
