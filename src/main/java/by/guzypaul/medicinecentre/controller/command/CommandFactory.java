package by.guzypaul.medicinecentre.controller.command;

import by.guzypaul.medicinecentre.controller.command.impl.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

import static by.guzypaul.medicinecentre.controller.command.CommandFactory.MethodType.*;

public enum CommandFactory {
    PROCEDURE_LIST(new ProcedureListForwardCommand(), "procedures", GET),
    PROCEDURE_PAGE(new ProcedureForwardCommand(), "procedure_page", GET),
    CONTACTS(new ContactsForwardCommand(), "contacts", GET),
    ABOUT_US(new AboutUsCommand(), "about_us", GET),
    AUTHORIZATION_PAGE(new AuthorizationPageCommand(), "authorization_page", GET),
    REGISTRATION_PAGE(new RegistrationPageCommand(), "registration_page", GET),
    DOCTOR_LIST(new DoctorListForwardCommand(), "doctors", GET),
    DOCTOR_PAGE(new DoctorForwardCommand(), "doctor_page", GET),
    REGISTRATION(new RegistrationCommand(), "registration", POST),
    AUTHORIZATION(new AuthorizationCommand(), "authorization", POST),
    LOGOUT(new LogoutCommand(), "logout", POST),
    ERROR_PAGE(new ErrorPageCommand(), "error_page", GET),
    PROFILE_PAGE(new ProfilePageCommand(), "profile_page", GET),
    CHANGE_LANGUAGE(new ChangeLanguageCommand(), "change_language", POST),
    APPOINTMENT_LIST(new AppointmentListCommand(),"appointments", GET),
    USER_LIST(new UserListCommand(), "users", GET),
    CHANGE_APPOINTMENT_PAGE(new ChangeAppointmentPageCommand(), "change_appointment_page", GET),
    CHANGE_APPOINTMENT(new ChangeAppointmentCommand(), "change_appointment", POST),
    DELETE_APPOINTMENT_PAGE (new DeleteAppointmentPageCommand(), "delete_appointment_page", GET),
    DELETE_APPOINTMENT(new DeleteAppointmentCommand(), "delete_appointment", POST),
    CHANGE_USER_PAGE(new ChangeUserPageCommand(),"change_user_page", GET),
    CHANGE_USER(new ChangeUserCommand(), "change_user", POST),
    CHANGE_DOCTOR_PAGE(new ChangeDoctorPageCommand(), "change_doctor_page", GET),
    CHANGE_DOCTOR(new ChangeDoctorCommand(), "change_doctor", POST);

    private final Command command;
    private final String commandName;
    private final MethodType methodType;

    CommandFactory(Command command, String commandName, MethodType methodType) {
        this.command = command;
        this.commandName = commandName;
        this.methodType = methodType;
    }

    public enum MethodType {
        POST,
        GET;
    }

    public Command getCommand() {
        return command;
    }

    public String getCommandName() {
        return commandName;
    }

    public MethodType getMethodType() {
        return methodType;
    }

    public static Command findCommand(HttpServletRequest request, MethodType methodType) throws CommandException {
        String command = request.getParameter("command");
        if (command == null || command.isEmpty()) {
            throw new CommandException("Unknown command");
        }

        return Arrays.stream(CommandFactory.values())
                .filter(currentCommand -> currentCommand.getCommandName().toUpperCase().equals(command.toUpperCase())
                        && currentCommand.getMethodType() == methodType)
                .findFirst()
                .map(CommandFactory::getCommand)
                .orElseThrow(() -> new CommandException("Invalid command"));
    }
}
