package by.guzypaul.medicinecentre.dao.mapper;

import by.guzypaul.medicinecentre.entity.Procedure;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoProcedureMapper {
    public Procedure mapProcedure (ResultSet resultSet) throws SQLException {
        Procedure procedure = new Procedure();
        procedure.setId(resultSet.getInt("procedure_id"));
        procedure.setDescription(resultSet.getString("description"));
        procedure.setName(resultSet.getString("procedure_name"));
        procedure.setImageName(resultSet.getString("image_name"));
        procedure.setPrice(resultSet.getBigDecimal("price")) ;
        procedure.setDuration(resultSet.getInt("duration"));

        return procedure;
    }
}
