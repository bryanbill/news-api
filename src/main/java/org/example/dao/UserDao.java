package org.example.dao;

import org.example.interfaces.IUser;
import org.example.models.Users;
import org.sql2o.Connection;

import java.util.List;

public class UserDao implements IUser {
    /**
     * @param connection 
     * @param id
     * @return
     */
    @Override
    public Users getUser(Connection connection, int id) {
        return null;
    }

    /**
     * @param connection 
     * @return
     */
    @Override
    public Users getAllUsers(Connection connection) {
        return null;
    }

    /**
     * @param connection 
     * @param departmentId
     * @return
     */
    @Override
    public List<Users> getAllUsersByDepartmentId(Connection connection, int departmentId) {
        return null;
    }

    /**
     * @param connection 
     * @param user
     * @return
     */
    @Override
    public boolean createUser(Connection connection, Users user) {
        return false;
    }

    /**
     * @param connection 
     * @param user
     * @return
     */
    @Override
    public boolean updateUser(Connection connection, Users user) {
        return false;
    }

    /**
     * @param connection 
     * @param id
     * @return
     */
    @Override
    public boolean deleteUser(Connection connection, int id) {
        return false;
    }
}
