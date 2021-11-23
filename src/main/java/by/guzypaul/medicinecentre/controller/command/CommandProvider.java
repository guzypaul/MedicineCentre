package by.guzypaul.medicinecentre.controller.command;

import by.guzypaul.medicinecentre.controller.command.impl.UnknownCommand;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CommandProvider {
    private static final Logger logger = LogManager.getLogger();

    public static Command defineCommand(String command) {
        Command current = null;
        logger.log(Level.INFO, "Command from controller: " + command);
        if (command == null || command.isEmpty()) {
            logger.log(Level.INFO, "empty command ");
            return new UnknownCommand();
        }
        try {
            CommandType currentType = CommandType.valueOf(command.toUpperCase());
            current = currentType.getCurrentCommand();
        } catch (IllegalArgumentException e) {
            logger.log(Level.ERROR, "empty command from catch ");
            current = new UnknownCommand();
        }
        return current;
    }
}
