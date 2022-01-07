package by.guzypaul.medicinecentre.controller;

import by.guzypaul.medicinecentre.dao.DaoException;
import by.guzypaul.medicinecentre.dao.connection.ConnectionPool;
import by.guzypaul.medicinecentre.dao.connection.ConnectionPoolException;
import by.guzypaul.medicinecentre.service.exception.ServiceException;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws DaoException, SQLException, ConnectionPoolException, ServiceException {
        ConnectionPool.getInstance().initializeConnectionPool(2);
        Connection connection = ConnectionPool.getInstance().acquireConnection();

        /*DoctorDaoImpl doctorDao = new DoctorDaoImpl();
        System.out.println(doctorDao.readByUserId(2));*/

        /*DoctorScheduleDaoImpl doctorScheduleDao = new DoctorScheduleDaoImpl();
        System.out.println(doctorScheduleDao.readByDoctorId(5));*/

      /*  ProcedureDaoImpl procedureDao = new ProcedureDaoImpl();
        System.out.println(procedureDao.readAll());*/

        /*AppointmentDaoImpl appointmentDao = new AppointmentDaoImpl();
        System.out.println(appointmentDao.readByDoctorId(8));*/

       /* UserService userService = ServiceFactory.getInstance().getUserService();
        System.out.println(userService.readByEmail("useafef@gmail.com"));*/
    }
}
