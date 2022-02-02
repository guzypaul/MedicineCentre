package by.guzypaul.medicinecentre.dao.mapper;

import by.guzypaul.medicinecentre.entity.Procedure;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The type Dao procedure mapper.
 * @author Guziy Paul
 */
public class DaoProcedureMapper {
    /**
     * Map procedure procedure.
     *
     * @param resultSet the result set
     * @return the procedure
     * @throws SQLException the sql exception
     */
    public Procedure mapProcedure (ResultSet resultSet) throws SQLException {
        Procedure procedure = new Procedure();
        procedure.setId(resultSet.getInt("procedure_id"));
        procedure.setDescription(resultSet.getString("description"));
        procedure.setName(resultSet.getString("procedure_name"));
        procedure.setImageName(resultSet.getString("image_name"));
        procedure.setPrice(resultSet.getBigDecimal("price")) ;
        procedure.setDuration(resultSet.getInt("duration"));
        procedure.setDoctorQualification(resultSet.getString("doctor_qualification"));

        return procedure;
    }
}
