package by.guzypaul.medicinecentre.controller;

import by.guzypaul.medicinecentre.controller.command.CommandException;
import by.guzypaul.medicinecentre.controller.command.CommandFactory;
import by.guzypaul.medicinecentre.controller.command.Router;
import by.guzypaul.medicinecentre.dao.connection.ConnectionPool;
import by.guzypaul.medicinecentre.dao.connection.ConnectionPoolException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/controller")
public class Controller extends HttpServlet {
    private static final Logger logger = LogManager.getRootLogger();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Router router = CommandFactory.findCommand(req).execute(req);
            if (router.getType() == Router.Type.FORWARD) {
                req.getRequestDispatcher(router.getPagePath()).forward(req, resp);
            } else {
                resp.sendRedirect(req.getContextPath() + router.getPagePath());
            }
        } catch (CommandException | NumberFormatException e) {
            logger.log(Level.ERROR, e);
            resp.sendRedirect(req.getContextPath() + "/controller?command=error_page");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    public void destroy() {
        try {
            ConnectionPool.getInstance().closeConnections();
        } catch (ConnectionPoolException e) {
            logger.log(Level.ERROR, e);
        }
    }

    @Override
    public void init() {
        try {
            ConnectionPool.getInstance().initializeConnectionPool(2);
        } catch (ConnectionPoolException e) {
            logger.log(Level.ERROR, e);
        }
    }
}
