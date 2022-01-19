package by.guzypaul.medicinecentre.controller.command.impl;

import by.guzypaul.medicinecentre.controller.command.Command;
import by.guzypaul.medicinecentre.controller.command.CommandException;
import by.guzypaul.medicinecentre.controller.command.Router;

import javax.servlet.http.HttpServletRequest;

public class CreateDoctorPageCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        return new Router("/jsp/create_doctor_page.jsp", Router.Type.FORWARD);
    }
}
