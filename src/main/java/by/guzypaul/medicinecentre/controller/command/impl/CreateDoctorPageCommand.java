package by.guzypaul.medicinecentre.controller.command.impl;

import by.guzypaul.medicinecentre.controller.command.Command;
import by.guzypaul.medicinecentre.controller.command.CommandException;
import by.guzypaul.medicinecentre.controller.command.Router;
import by.guzypaul.medicinecentre.entity.Qualification;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Create doctor page command.
 * @author Guziy Paul
 * @see Command
 */
public class CreateDoctorPageCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        List<String> qualificationList = new ArrayList<>();
        for (Qualification qualification : Qualification.values()) {
            String qualificationName = qualification.getQualificationName();
            qualificationList.add(qualificationName);
        }
        request.setAttribute("qualificationList", qualificationList);
        return new Router("/jsp/create_doctor_page.jsp", Router.Type.FORWARD);
    }
}
