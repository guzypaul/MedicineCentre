package by.guzypaul.medicinecentre.controller;

import by.guzypaul.medicinecentre.dao.DaoException;
import by.guzypaul.medicinecentre.dao.connection.ConnectionPool;
import by.guzypaul.medicinecentre.dao.connection.ConnectionPoolException;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws DaoException, SQLException, ConnectionPoolException {
        ConnectionPool.getInstance().initializeConnectionPool(2);
        Connection connection = ConnectionPool.getInstance().acquireConnection();

        /*DoctorDaoImpl doctorDao = new DoctorDaoImpl();
        System.out.println(doctorDao.readAll());*/

        /*DoctorScheduleDaoImpl doctorScheduleDao = new DoctorScheduleDaoImpl();
        System.out.println(doctorScheduleDao.readAll());*/

      /*  ProcedureDaoImpl procedureDao = new ProcedureDaoImpl();
        System.out.println(procedureDao.readAll());*/


        /*AppointmentDaoImpl appointmentDao = new AppointmentDaoImpl();
        System.out.println(appointmentDao.readAll());*/


    }
}
