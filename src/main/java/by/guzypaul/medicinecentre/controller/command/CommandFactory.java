package by.guzypaul.medicinecentre.controller.command;

import by.guzypaul.medicinecentre.controller.command.impl.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

public enum CommandFactory {
    PROCEDURE_LIST(new ProcedureListForwardCommand(), "procedures"),
    PROCEDURE_PAGE(new ProcedureForwardCommand(), "procedure_page"),
    CONTACTS(new ContactsForwardCommand(), "contacts"),
    ABOUT_US(new AboutUsCommand(), "about_us"),
    AUTHORIZATION_PAGE(new AuthorizationPageCommand(),"authorization_page"),
    REGISTRATION_PAGE(new RegistrationPageCommand(), "registration_page"),
    DOCTOR_LIST(new DoctorListForwardCommand(), "doctors"),
    DOCTOR_PAGE(new DoctorForwardCommand(), "doctor_page"),
    REGISTRATION(new RegistrationCommand(), "registration"),
    AUTHORIZATION(new AuthorizationCommand(), "authorization"),
    LOGOUT(new LogoutCommand(), "logout"),
    ERROR_PAGE(new ErrorPageCommand(), "error_page");


    private final Command command;
    private final String commandName;

    CommandFactory(Command command, String commandName) {
        this.command = command;
        this.commandName = commandName;
    }

    public Command getCommand() {
        return command;
    }

    public String getCommandName() {
        return commandName;
    }

    public static Command findCommand(HttpServletRequest request) throws CommandException {
        String command = request.getParameter("command");
        if (command == null) {
            throw new CommandException("Command is null");
        }

        return Arrays.stream(CommandFactory.values())
                .filter(currentCommand -> currentCommand.getCommandName().toUpperCase().equals(command.toUpperCase()))
                .findFirst()
                .map(CommandFactory::getCommand)
                .orElseThrow(() -> new CommandException("Invalid command"));
    }
}
