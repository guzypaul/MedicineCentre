package by.guzypaul.medicinecentre.controller;

import by.guzypaul.medicinecentre.dao.DaoException;
import by.guzypaul.medicinecentre.dao.impl.ProcedureDaoImpl;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws DaoException, SQLException {
        ProcedureDaoImpl procedureDao = new ProcedureDaoImpl();
        procedureDao.setConnection(DriverManager.getConnection("jdbc:mysql://localhost:3306/medicene_centre", ));
        System.out.println(procedureDao.readById(1));
    }
}
