package by.guzypaul.medicinecentre.controller.filter;

import by.guzypaul.medicinecentre.controller.command.CommandFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static by.guzypaul.medicinecentre.controller.command.CommandFactory.*;


public enum CommandAccessLevel {
    GUEST(Arrays.asList(AUTHORIZATION, AUTHORIZATION_PAGE, REGISTRATION, REGISTRATION_PAGE)),
    USER(Arrays.asList(LOGOUT, PROFILE_PAGE, CHANGE_USER_PAGE, CHANGE_USER)),
    DOCTOR(Arrays.asList(LOGOUT, PROFILE_PAGE)),
    MODERATOR(Arrays.asList(LOGOUT, PROFILE_PAGE, USER_LIST, CHANGE_APPOINTMENT_PAGE, CHANGE_APPOINTMENT,
            DELETE_APPOINTMENT_PAGE, DELETE_APPOINTMENT, CHANGE_USER_PAGE, CHANGE_USER)),
    ADMIN(Arrays.asList(LOGOUT, PROFILE_PAGE, USER_LIST, CHANGE_APPOINTMENT_PAGE, CHANGE_APPOINTMENT,
            DELETE_APPOINTMENT_PAGE, DELETE_APPOINTMENT, CHANGE_USER_PAGE, CHANGE_USER, CHANGE_DOCTOR_PAGE,
            CHANGE_DOCTOR, CHANGE_DOCTOR_SCHEDULE_PAGE, CHANGE_DOCTOR_SCHEDULE)),
    DEFAULT(Arrays.asList(PROCEDURE_LIST, PROCEDURE_PAGE, DOCTOR_LIST, DOCTOR_PAGE, ABOUT_US, CONTACTS,
            CHANGE_LANGUAGE, APPOINTMENT_LIST));

    private final List<CommandFactory> commands;

    CommandAccessLevel(List<CommandFactory> commands) {
        this.commands = commands;
    }

    public List<CommandFactory> getCommands() {
        return commands;
    }

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
