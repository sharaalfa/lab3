package models.dao;

import common.exceptions.UserDaoException;
import models.connector.Connector;
import models.pojo.Users;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by innopolis on 26.02.17.
 */
public class UsersDao {

    private static Logger logger = Logger.getLogger(UsersDao.class);
    private static final String SQL_FIND_USERS =  "SELECT * FROM users WHERE email=? AND password=?";
    private static final String SQL_CREATE_USER =
            "INSERT INTO users (user_name, password, email, last_name, first_name, middle_name, role_id, is_active , phone, address) " +
                    "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public static Users getUserByLoginAndPassword(String email, String password) throws UserDaoException {

        logger.debug(email + " " + password);
        Users users = null;
        try(Connection connection = Connector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_USERS)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                logger.debug("find");
                users = new Users(
                        resultSet.getInt("id"),
                        resultSet.getString("user_name"),
                        resultSet.getString("password"),
                        resultSet.getString("email"),
                        resultSet.getString("last_name"),
                        resultSet.getString("first_name"),
                        resultSet.getString("middle_name"),
                        resultSet.getInt("role_id"),
                        resultSet.getBoolean("is_active"),
                        resultSet.getString("phone"),
                        resultSet.getString("address")
                );
            }else{
                logger.debug(email + " " + password + " not found");
            }
        } catch (SQLException e) {
            logger.error(e);
            throw new UserDaoException();
        }
        return users;
    }

    public static boolean registrationUser(String user_name, String password, String email, String lastName,
                                           String firstName, String middleName, String phone, String address){
        try(Connection connection = Connector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_CREATE_USER)) {
            preparedStatement.setString(1, user_name);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, lastName);
            preparedStatement.setString(5, firstName);
            preparedStatement.setString(6, middleName);
            preparedStatement.setInt(7, 3);
            preparedStatement.setBoolean(8, true);
            preparedStatement.setString(9, phone);
            preparedStatement.setString(10, address);
            //preparedStatement.setString(4, "user");
            int count = preparedStatement.executeUpdate();
            if(count > 0){
                logger.debug("inserted " + count);
                return true;
            }else{
                logger.debug(user_name + " " + password + " not inserted");
            }
        } catch (SQLException e) {
            logger.error(e);
        }
        return false;
    }
}
