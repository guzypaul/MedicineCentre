package by.guzypaul.medicinecentre.controller;

import by.guzypaul.medicinecentre.dao.DaoException;
import by.guzypaul.medicinecentre.dao.connection.ConnectionPool;
import by.guzypaul.medicinecentre.dao.connection.ConnectionPoolException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.regex.Pattern;

public class Main {
    private static final Pattern DURATION_REGEX = Pattern.compile("([-+]?)P(?:([-+]?[0-9]+)D)?" +
                    "(T(?:([-+]?[0-9]+)H)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)(?:[.,]([0-9]{0,9}))?S)?)?",
            Pattern.CASE_INSENSITIVE);
    public static void main(String[] args) throws DaoException, SQLException, ConnectionPoolException {
        ConnectionPool.getInstance().initializeConnectionPool(2);
        Connection connection = ConnectionPool.getInstance().acquireConnection();

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

        /*AppointmentDaoImpl appointmentDao = new AppointmentDaoImpl();
        appointmentDao.setConnection(connection);
        System.out.println(appointmentDao.readAll());*/

    }
}
