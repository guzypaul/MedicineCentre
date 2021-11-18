package by.guzypaul.medicinecentre.dao.impl;

import by.guzypaul.medicinecentre.dao.DaoException;
import by.guzypaul.medicinecentre.dao.mapper.DaoDoctorMapper;
import by.guzypaul.medicinecentre.dao.DoctorDao;
import by.guzypaul.medicinecentre.entity.Doctor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DoctorDaoImpl implements DoctorDao {
    private static final String READ_ALL_DOCTOR_SQL = "SELECT doctors.id, doctors.qualification, " +
            "doctors.rank, doctors.doctor_info FROM doctors";

    private final DaoDoctorMapper daoDoctorMapper = new DaoDoctorMapper();
    private Connection connection;

    @Override
    public List<Doctor> readAll() throws DaoException {
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(READ_ALL_DOCTOR_SQL);
            List<Doctor> doctorList = new ArrayList<>();
            while (resultSet.next()) {
                doctorList.add(daoDoctorMapper.mapDoctor(resultSet));
            }

            return doctorList;
        } catch (SQLException throwables) {
            throw new DaoException(throwables.getMessage());
        }
    }

    @Override
    public Doctor readById(Integer id) throws DaoException {
        return null;
    }

    @Override
    public boolean deleteById(Integer id) throws DaoException {
        return false;
    }

    @Override
    public boolean create(Doctor entity) throws DaoException {
        return false;
    }

    @Override
    public boolean update(Doctor entity) throws DaoException {
        return false;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
