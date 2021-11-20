package by.guzypaul.medicinecentre.service.interfaces;

import by.guzypaul.medicinecentre.entity.Procedure;

public interface ProcedureService extends BaseService<Integer, Procedure>{
    boolean checkData (Procedure entity);
}
