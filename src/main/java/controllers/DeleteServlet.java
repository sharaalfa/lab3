package controllers;

import common.exceptions.UserDaoException;
import org.apache.log4j.Logger;

import services.RolesService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by innopolis on 23.02.17.
 */
public class DeleteServlet extends HttpServlet {
    static Logger logger = Logger.getLogger(EditServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        try {
            if (RolesService.delete(id)) {
                resp.sendRedirect("/list");
            } else {
                resp.sendRedirect("/error.jsp");
            }
        } catch (UserDaoException e) {
            logger.error(e);
            resp.sendRedirect("/error.jsp");
        }
    }
}
