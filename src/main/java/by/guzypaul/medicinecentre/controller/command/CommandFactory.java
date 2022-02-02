package by.guzypaul.medicinecentre.controller.command;

import by.guzypaul.medicinecentre.controller.command.impl.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

import static by.guzypaul.medicinecentre.controller.command.CommandFactory.MethodType.*;

/**
 * The enum Command factory.
 * @author Guziy Paul
 */
public enum CommandFactory {
    /**
     * The Procedure list.
     */
    PROCEDURE_LIST(new ProcedureListForwardCommand(), "procedures", GET),
    /**
     * The Procedure page.
     */
    PROCEDURE_PAGE(new ProcedureForwardCommand(), "procedure_page", GET),
    /**
     * The Contacts.
     */
    CONTACTS(new ContactsForwardCommand(), "contacts", GET),
    /**
     * The About us.
     */
    ABOUT_US(new AboutUsCommand(), "about_us", GET),
    /**
     * The Authorization page.
     */
    AUTHORIZATION_PAGE(new AuthorizationPageCommand(), "authorization_page", GET),
    /**
     * The Registration page.
     */
    REGISTRATION_PAGE(new RegistrationPageCommand(), "registration_page", GET),
    /**
     * The Doctor list.
     */
    DOCTOR_LIST(new DoctorListForwardCommand(), "doctors", GET),
    /**
     * The Doctor page.
     */
    DOCTOR_PAGE(new DoctorForwardCommand(), "doctor_page", GET),
    /**
     * The Registration.
     */
    REGISTRATION(new RegistrationCommand(), "registration", POST),
    /**
     * The Authorization.
     */
    AUTHORIZATION(new AuthorizationCommand(), "authorization", POST),
    /**
     * The Logout.
     */
    LOGOUT(new LogoutCommand(), "logout", POST),
    /**
     * The Error page.
     */
    ERROR_PAGE(new ErrorPageCommand(), "error_page", GET),
    /**
     * The Profile page.
     */
    PROFILE_PAGE(new ProfilePageCommand(), "profile_page", GET),
    /**
     * The Change language.
     */
    CHANGE_LANGUAGE(new ChangeLanguageCommand(), "change_language", POST),
    /**
     * The Appointment list.
     */
    APPOINTMENT_LIST(new AppointmentListCommand(),"appointments", GET),
    /**
     * The User list.
     */
    USER_LIST(new UserListCommand(), "users", GET),
    /**
     * The Change appointment page.
     */
    CHANGE_APPOINTMENT_PAGE(new ChangeAppointmentPageCommand(), "change_appointment_page", GET),
    /**
     * The Change appointment.
     */
    CHANGE_APPOINTMENT(new ChangeAppointmentCommand(), "change_appointment", POST),
    /**
     * The Delete appointment page.
     */
    DELETE_APPOINTMENT_PAGE (new DeleteAppointmentPageCommand(), "delete_appointment_page", GET),
    /**
     * The Delete appointment.
     */
    DELETE_APPOINTMENT(new DeleteAppointmentCommand(), "delete_appointment", POST),
    /**
     * The Change user page.
     */
    CHANGE_USER_PAGE(new ChangeUserPageCommand(),"change_user_page", GET),
    /**
     * The Change user.
     */
    CHANGE_USER(new ChangeUserCommand(), "change_user", POST),
    /**
     * The Change doctor page.
     */
    CHANGE_DOCTOR_PAGE(new ChangeDoctorPageCommand(), "change_doctor_page", GET),
    /**
     * The Change doctor.
     */
    CHANGE_DOCTOR(new ChangeDoctorCommand(), "change_doctor", POST),
    /**
     * The Change doctor schedule page.
     */
    CHANGE_DOCTOR_SCHEDULE_PAGE(new ChangeDoctorSchedulePageCommand(), "change_doctor_schedule_page", GET),
    /**
     * The Change doctor schedule.
     */
    CHANGE_DOCTOR_SCHEDULE(new ChangeDoctorScheduleCommand(), "change_doctor_schedule", POST),
    /**
     * The Delete doctor and schedule page.
     */
    DELETE_DOCTOR_AND_SCHEDULE_PAGE(new DeleteDoctorAndSchedulePageCommand(), "delete_doctor_and_schedule_page", GET),
    /**
     * The Delete doctor and schedule.
     */
    DELETE_DOCTOR_AND_SCHEDULE(new DeleteDoctorAndScheduleCommand(), "delete_doctor_and_schedule", POST),
    /**
     * The Change procedure page.
     */
    CHANGE_PROCEDURE_PAGE(new ChangeProcedurePageCommand(), "change_procedure_page", GET),
    /**
     * The Change procedure.
     */
    CHANGE_PROCEDURE(new ChangeProcedureCommand(), "change_procedure", POST),
    /**
     * The Delete procedure page.
     */
    DELETE_PROCEDURE_PAGE(new DeleteProcedurePageCommand(), "delete_procedure_page", GET),
    /**
     * The Delete procedure.
     */
    DELETE_PROCEDURE(new DeleteProcedureCommand(), "delete_procedure", POST),
    /**
     * The Create doctor page.
     */
    CREATE_DOCTOR_PAGE(new CreateDoctorPageCommand(), "create_doctor_page", GET),
    /**
     * The Create doctor.
     */
    CREATE_DOCTOR(new CreateDoctorCommand(), "create_doctor", POST),
    /**
     * The Create procedure page.
     */
    CREATE_PROCEDURE_PAGE(new CreateProcedurePageCommand(), "create_procedure_page", GET),
    /**
     * The Create procedure.
     */
    CREATE_PROCEDURE(new CreateProcedureCommand(), "create_procedure", POST),
    /**
     * The Create appointment page.
     */
    CREATE_APPOINTMENT_PAGE(new CreateAppointmentPageCommand(), "create_appointment_page", GET),
    /**
     * The Create appointment.
     */
    CREATE_APPOINTMENT(new CreateAppointmentCommand(), "create_appointment", POST);

    private final Command command;
    private final String commandName;
    private final MethodType methodType;

    CommandFactory(Command command, String commandName, MethodType methodType) {
        this.command = command;
        this.commandName = commandName;
        this.methodType = methodType;
    }

    /**
     * The enum Method type.
     */
    public enum MethodType {
        /**
         * Post method type.
         */
        POST,
        /**
         * Get method type.
         */
        GET;
    }

    /**
     * Gets command.
     *
     * @return the command
     */
    public Command getCommand() {
        return command;
    }

    /**
     * Gets command name.
     *
     * @return the command name
     */
    public String getCommandName() {
        return commandName;
    }

    /**
     * Gets method type.
     *
     * @return the method type
     */
    public MethodType getMethodType() {
        return methodType;
    }

    /**
     * Find command command.
     *
     * @param request    the request
     * @param methodType the method type
     * @return the command
     * @throws CommandException the command exception
     */
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
