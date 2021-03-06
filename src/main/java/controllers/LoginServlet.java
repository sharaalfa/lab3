package controllers;

import common.exceptions.UserDaoException;
import org.apache.log4j.Logger;
import services.RolesService;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by bot on 23.02.17.
 */
public class LoginServlet extends HttpServlet {

    private static Logger logger = Logger.getLogger(LoginServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.trace("onget");
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.trace("on post");
        String user_name = req.getParameter("user_name");
        String password = req.getParameter("password");
        try {
            if(UserService.authorize(user_name, password)){
                logger.trace("true");
                resp.sendRedirect("/list");
            }else{
                logger.trace("false");
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
            }
        } catch (UserDaoException e) {
            logger.error(e);
            resp.sendRedirect("/error.jsp");
        }
    }
}
