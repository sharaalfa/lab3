package controllers;

import common.exceptions.UserDaoException;
import models.pojo.Roles;
import org.apache.log4j.Logger;
import services.RolesService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dmitrii on 23.02.17.
 */
public class EditServlet extends HttpServlet {
    static Logger logger = Logger.getLogger(EditServlet.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        logger.trace("редактирование" + id);
        Roles roles = null;
        try {
            roles = RolesService.getRolesById(id);
        } catch (UserDaoException e) {
            logger.error(e);
            resp.sendRedirect("/error.jsp");
        }
        req.setAttribute("roles", roles);
        req.getRequestDispatcher("/edit.jsp").forward(req, resp);
        //super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        Integer id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        try {
            if (RolesService.update(id, name, description)) {
                resp.sendRedirect("/list"); //edit/?id="+id);
            } else {
                resp.sendRedirect("/error.jsp");
            }
        } catch (UserDaoException e) {
            logger.error(e);
            resp.sendRedirect("/error.jsp");
        }


    }
}
