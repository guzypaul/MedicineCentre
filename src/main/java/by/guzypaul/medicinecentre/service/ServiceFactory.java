package by.guzypaul.medicinecentre.service;

import by.guzypaul.medicinecentre.service.impl.ProcedureServiceImpl;
import by.guzypaul.medicinecentre.service.interfaces.ProcedureService;

public class ServiceFactory {
    private static final ServiceFactory INSTANCE = new ServiceFactory();
    private final ProcedureService procedureService;

    public ServiceFactory() {
        procedureService = new ProcedureServiceImpl();
    }

    public static ServiceFactory getInstance() {
        return INSTANCE;
    }

    public ProcedureService getProcedureService() {
        return procedureService;
    }
}

