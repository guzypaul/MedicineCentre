package by.guzypaul.medicinecentre.controller.filter;

import by.guzypaul.medicinecentre.controller.command.CommandFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static by.guzypaul.medicinecentre.controller.command.CommandFactory.*;


/**
 * The enum Command access level.
 * @author Guziy Paul
 */
public enum CommandAccessLevel {
    /**
     * Default command access level.
     */
    DEFAULT(Arrays.asList(PROCEDURE_LIST, PROCEDURE_PAGE, DOCTOR_LIST, DOCTOR_PAGE, ABOUT_US, CONTACTS,
            CHANGE_LANGUAGE, ERROR_PAGE)),
    /**
     * Guest command access level.
     */
    GUEST(Arrays.asList(AUTHORIZATION, AUTHORIZATION_PAGE, REGISTRATION, REGISTRATION_PAGE)),
    /**
     * User command access level.
     */
    USER(Arrays.asList(LOGOUT, PROFILE_PAGE, CHANGE_USER_PAGE, CHANGE_USER, APPOINTMENT_LIST, CREATE_APPOINTMENT_PAGE,
            CREATE_APPOINTMENT)),
    /**
     * Doctor command access level.
     */
    DOCTOR(Arrays.asList(LOGOUT, PROFILE_PAGE, APPOINTMENT_LIST)),
    /**
     * Moderator command access level.
     */
    MODERATOR(Arrays.asList(LOGOUT, PROFILE_PAGE, USER_LIST, APPOINTMENT_LIST, CHANGE_APPOINTMENT_PAGE, CHANGE_APPOINTMENT,
            DELETE_APPOINTMENT_PAGE, DELETE_APPOINTMENT, CHANGE_USER_PAGE, CHANGE_USER)),
    /**
     * Admin command access level.
     */
    ADMIN(Arrays.asList(LOGOUT, PROFILE_PAGE, USER_LIST,
            APPOINTMENT_LIST, CHANGE_APPOINTMENT_PAGE, CHANGE_APPOINTMENT, DELETE_APPOINTMENT_PAGE, DELETE_APPOINTMENT,
            CHANGE_USER_PAGE, CHANGE_USER,
            CHANGE_DOCTOR_PAGE, CHANGE_DOCTOR,
            CHANGE_DOCTOR_SCHEDULE_PAGE, CHANGE_DOCTOR_SCHEDULE,
            DELETE_DOCTOR_AND_SCHEDULE_PAGE, DELETE_DOCTOR_AND_SCHEDULE,
            CREATE_PROCEDURE_PAGE, CREATE_PROCEDURE, CHANGE_PROCEDURE_PAGE, CHANGE_PROCEDURE, DELETE_PROCEDURE_PAGE, DELETE_PROCEDURE,
            CREATE_DOCTOR_PAGE, CREATE_DOCTOR));

    private final List<CommandFactory> commands;

    CommandAccessLevel(List<CommandFactory> commands) {
        this.commands = commands;
    }

    /**
     * Gets commands.
     *
     * @return the commands
     */
    public List<CommandFactory> getCommands() {
        return commands;
    }

    /**
     * Is access command boolean.
     *
     * @param request the request
     * @return the boolean
     */
    public static boolean isAccessCommand(HttpServletRequest request) {
        String command = request.getParameter("command");
        if (command == null || command.isEmpty()) {
            return false;
        }

        String role = (String) request.getSession().getAttribute("role");

        List<CommandAccessLevel> accessLevels = Arrays.stream(CommandAccessLevel.values())
                .filter(level -> level.getCommands().stream()
                        .map(CommandFactory::getCommandName)
                        .collect(Collectors.toList())
                        .contains(command.toLowerCase()))
                .collect(Collectors.toList());

        return !accessLevels.isEmpty() && (accessLevels.contains(DEFAULT) || accessLevels.stream()
                .map(CommandAccessLevel::toString)
                .anyMatch(level -> level.equals(role.toUpperCase())));
    }
}
