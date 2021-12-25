package by.guzypaul.medicinecentre.controller.command.impl;

import by.guzypaul.medicinecentre.controller.command.Command;
import by.guzypaul.medicinecentre.controller.command.CommandException;
import by.guzypaul.medicinecentre.controller.command.Router;

import javax.servlet.http.HttpServletRequest;

public class ContactsForwardCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        return new Router("/jsp/contacts.jsp", Router.Type.FORWARD);
    }
}
