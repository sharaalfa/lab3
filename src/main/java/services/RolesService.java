package services;

import common.exceptions.UserDaoException;
import models.dao.RolesDao;
import models.pojo.Roles;

import java.util.List;

/**
 * Created by innopolis on 27.02.17.
 */
public class RolesService {
    public static List<Roles> getAllRoles(){
        return RolesDao.getAllRoles();
    }


    public static Roles getRolesById(int id) throws UserDaoException {
        return RolesDao.getRolesById(id);
    }

    public static boolean update(int id, String name, String description)
            throws UserDaoException {
        return RolesDao.update(id, name, description);
    }

    public static boolean delete(int id) throws UserDaoException {
        return RolesDao.delete(id);
    }

    public static boolean create(String name, String description)
            throws UserDaoException {
        return RolesDao.create(name, description);
    }

}
