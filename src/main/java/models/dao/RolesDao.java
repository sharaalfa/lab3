package models.dao;

import common.exceptions.UserDaoException;
import models.connector.Connector;
import models.pojo.Roles;
import models.pojo.Student;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by innopolis on 27.02.17.
 */
public class RolesDao {
    private static final Logger logger = Logger.getLogger(RolesDao.class);

    private static final String SQL_GET_ROLES = "SELECT * FROM  roles WHERE id=?";
    private static final String SQL_ALL_USERS = "SELECT * FROM  roles ORDER BY id";
    private static final String SQL_UPDATE = "UPDATE roles SET name=?, description=? WHERE id=?";
    private static final String SQL_DELETE = "DELETE FROM roles WHERE id=?";
    private static final String SQL_CREATE = "INSERT INTO roles(\"name\", description) " +
            "VALUES(?,?)";
    private static final String SQL_ALL_ROLES = "SELECT * FROM roles";

    public static List<Roles> getAllRoles(){
        List<Roles> rolesList = new ArrayList<>();
        try(Connection connection = Connector.getConnection()){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_ALL_USERS);

            while(resultSet.next()) {
                logger.debug(resultSet.getString("name"));

                Roles roles = new Roles(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("description")
                );
                rolesList.add(roles);
            }
        } catch (SQLException e) {
            logger.error(e);
        }
        return  rolesList;
    }


   /*public static List<Student> getList(){
        List<Student> list = new ArrayList<>();
        try (Connection connection = Connector.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SQL_ALL_ROLES);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                list.add(
                        new Roles(
                                resultSet.getInt("id"),
                                resultSet.getString("name"),
                                resultSet.getString("age")

                        )
                );
            }
            statement.close();
        } catch (SQLException e) {
            logger.error(e);
            //throw new UserDaoException();
        }

        return list;
    }*/


    public static Roles getRolesById(int id) throws UserDaoException {
        try (Connection connection = Connector.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SQL_GET_ROLES);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new Roles(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("description")

                );
            }
            statement.close();
        } catch (SQLException e) {
            logger.error(e);
            throw new UserDaoException();
        }

        return null;
    }

    public static boolean update(int id, String name, String description)
            throws UserDaoException {
        try (Connection connection = Connector.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SQL_UPDATE);
            statement.setString(1, name);
            statement.setString(2, description);
            statement.setInt(3, id);
            int count = statement.executeUpdate();

            if (count > 0) {
                return true;
            }
            statement.close();
        } catch (SQLException e) {
            logger.error(e);
            throw new UserDaoException();
        }

        return false;
    }

    public static boolean delete(int id) throws UserDaoException {
        try (Connection connection = Connector.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SQL_DELETE);
            statement.setInt(1, id);
            int count = statement.executeUpdate();

            if (count > 0) {
                return true;
            }
            statement.close();
        } catch (SQLException e) {
            logger.error(e);
            throw new UserDaoException();
        }

        return false;
    }

    public static boolean create(String name, String description)
            throws UserDaoException {
        try (Connection connection = Connector.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SQL_CREATE);
            statement.setString(1, name);
            statement.setString(2, description);

            int count = statement.executeUpdate();

            if (count > 0) {
                return true;
            }
            statement.close();
        } catch (SQLException e) {
            logger.error(e);
            throw new UserDaoException();
        }

        return false;
    }
}
