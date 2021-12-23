package by.guzypaul.medicinecentre.controller.command;

import by.guzypaul.medicinecentre.controller.command.impl.ProcedurePageForwardCommand;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

public enum CommandFactory {
    PROCEDURE_PAGE(new ProcedurePageForwardCommand(), "procedures");

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
        if(command == null) {
            throw new CommandException("Command is null");
        }

        return Arrays.stream(CommandFactory.values())
                .filter(currentCommand -> currentCommand.getCommandName().toUpperCase().equals(command.toUpperCase()))
                .findFirst()
                .map(CommandFactory::getCommand)
                .orElseThrow(() -> new CommandException("Invalid command"));
    }
}
