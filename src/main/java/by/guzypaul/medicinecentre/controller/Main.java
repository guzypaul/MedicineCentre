package by.guzypaul.medicinecentre.controller;

import by.guzypaul.medicinecentre.dao.exception.DaoException;
import by.guzypaul.medicinecentre.dao.impl.DoctorScheduleDaoImpl;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws DaoException, SQLException {
        Properties properties = new Properties();
        properties.put("user", "root");
        properties.put("password", "1111");
        properties.put("serverTimezone","UTC");

//        DoctorDaoImpl doctorDao = new DoctorDaoImpl();
//        doctorDao.setConnection(DriverManager.getConnection("jdbc:mysql://localhost:3306/medicine_centre", properties ));
//        System.out.println(doctorDao.readAll());

        DoctorScheduleDaoImpl doctorScheduleDao = new DoctorScheduleDaoImpl();
        doctorScheduleDao.setConnection(DriverManager.getConnection("jdbc:mysql://localhost:3306/medicine_centre", properties ));
        System.out.println(doctorScheduleDao.readAll());

        //System.out.println(procedureDao.update(new Procedure(4,"burning", "image.jpg", new BigDecimal("300"), "ok", Duration.ofMinutes(120))));

    }
}
