package controllers;

import org.apache.log4j.Logger;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by bot on 23.02.17.
 */
public class RegistrationServlet extends HttpServlet {

    private static Logger logger = Logger.getLogger(RegistrationServlet.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.trace("REG on post");
        String user_name = req.getParameter("user_name");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String last_name = req.getParameter("lastName");
        String first_name = req.getParameter("firstName");
        String middle_name = req.getParameter("middleName");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");


        if(UserService.registration(user_name, password, email, last_name, first_name, middle_name, phone, address)){
            logger.trace("true");
            resp.sendRedirect("/user_name");
        }else{
            logger.trace("false");
            req.getRequestDispatcher("/error.jsp").forward(req, resp);
        }
    }
}
