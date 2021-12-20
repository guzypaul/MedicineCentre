package by.guzypaul.medicinecentre.controller;

import by.guzypaul.medicinecentre.dao.exception.DaoException;
import by.guzypaul.medicinecentre.dao.impl.AppointmentDaoImpl;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws DaoException, SQLException {
        Properties properties = new Properties();
        properties.put("user", "root");
        properties.put("password", "1111");
        properties.put("serverTimezone","UTC");

        /*DoctorDaoImpl doctorDao = new DoctorDaoImpl();
        doctorDao.setConnection(DriverManager.getConnection("jdbc:mysql://localhost:3306/medicine_centre", properties ));
        System.out.println(doctorDao.readAll());*/

       /* DoctorScheduleDaoImpl doctorScheduleDao = new DoctorScheduleDaoImpl();
        doctorScheduleDao.setConnection(DriverManager.getConnection("jdbc:mysql://localhost:3306/medicine_centre", properties ));
        System.out.println(doctorScheduleDao.readAll());*/

        /*ProcedureDaoImpl procedureDao = new ProcedureDaoImpl();
        procedureDao.setConnection(DriverManager.getConnection("jdbc:mysql://localhost:3306/medicine_centre", properties ));
        System.out.println(procedureDao.readAll());*/

        /*UserDaoImpl userDao = new UserDaoImpl();
        userDao.setConnection(DriverManager.getConnection("jdbc:mysql://localhost:3306/medicine_centre", properties ));
        System.out.println(userDao.readAll());*/

        AppointmentDaoImpl appointmentDao = new AppointmentDaoImpl();
        appointmentDao.setConnection(DriverManager.getConnection("jdbc:mysql://localhost:3306/medicine_centre", properties ));
        System.out.println(appointmentDao.readAll());
    }
}
