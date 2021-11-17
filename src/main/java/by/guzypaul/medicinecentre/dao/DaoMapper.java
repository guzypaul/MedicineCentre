package by.guzypaul.medicinecentre.dao;

import by.guzypaul.medicinecentre.entity.Procedure;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoMapper {
    public Procedure mapProcedure (ResultSet resultSet) throws SQLException {
        Procedure procedure = new Procedure();
        procedure.setProcedureId(resultSet.getInt("id"));
        procedure.setDescription(resultSet.getString("description"));
        procedure.setName(resultSet.getString("name"));
        procedure.setImageName(resultSet.getString("image_name"));
        procedure.setPrice(resultSet.getBigDecimal("price")) ;

        return procedure;
    }
}
