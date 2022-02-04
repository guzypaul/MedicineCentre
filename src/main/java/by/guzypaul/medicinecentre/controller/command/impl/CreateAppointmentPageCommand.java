package by.guzypaul.medicinecentre.controller.command.impl;

import by.guzypaul.medicinecentre.controller.command.Command;
import by.guzypaul.medicinecentre.controller.command.CommandException;
import by.guzypaul.medicinecentre.controller.command.Router;
import by.guzypaul.medicinecentre.entity.AppointmentStatus;
import by.guzypaul.medicinecentre.entity.Doctor;
import by.guzypaul.medicinecentre.entity.Procedure;
import by.guzypaul.medicinecentre.service.ServiceFactory;
import by.guzypaul.medicinecentre.service.exception.ServiceException;
import by.guzypaul.medicinecentre.service.DoctorService;
import by.guzypaul.medicinecentre.service.ProcedureService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

/**
 * The type Create appointment page command.
 * @author Guziy Paul
 * @see Command
 */
public class CreateAppointmentPageCommand implements Command {
    private final ProcedureService procedureService;
    private final DoctorService doctorService;

    /**
     * Instantiates a new Create appointment page command.
     */
    public CreateAppointmentPageCommand() {
        procedureService = ServiceFactory.getInstance().getProcedureService();
        doctorService = ServiceFactory.getInstance().getDoctorService();
    }

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        try {
            String procedureId = request.getParameter("procedureId");
            Optional<Procedure> procedureOptional = procedureService.readById(procedureId);

            if (procedureOptional.isPresent()) {
                String doctorQualification = procedureOptional.get().getDoctorQualification().getName();
                List<Doctor> doctorList = doctorService.readByQualification(doctorQualification);
                request.setAttribute("doctorList", doctorList);
                request.setAttribute("procedureId", procedureId);
                request.setAttribute("procedureName", procedureOptional.get().getName());
                request.setAttribute("status", AppointmentStatus.CLAIMED);
                return new Router("/jsp/create_appointment_page.jsp", Router.Type.FORWARD);
            }

            throw new CommandException("Invalid procedure!");
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
    }
}
