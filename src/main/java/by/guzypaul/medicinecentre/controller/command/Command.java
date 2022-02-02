package by.guzypaul.medicinecentre.controller.command;

import javax.servlet.http.HttpServletRequest;

/**
 * The interface for implementation command pattern.
 * @author Guziy Paul
 */
public interface Command {
    /**
     * Execute router.
     *
     * @param request the request
     * @return the command result (the router)
     * @throws CommandException the command exception
     */
    Router execute(HttpServletRequest request) throws CommandException;
}
