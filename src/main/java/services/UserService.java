package services;

import common.exceptions.UserDaoException;
import models.dao.UsersDao;

/**
 * Created by bot on 23.02.17.
 */
public class UserService {
    public static boolean authorize(String user_name, String password) throws UserDaoException {
        if(UsersDao.getUserByLoginAndPassword(user_name, password) != null){
            return true;
        }
        return false;
    }

    public static boolean registration(String user_name, String password, String email, String last_name,
                                       String first_name, String middle_name, String phone, String address){
        return UsersDao.registrationUser(user_name, password, email,
                last_name, first_name, middle_name, phone, address);
    }
}
