package org.example.interfaces;

import org.example.models.Users;
import org.sql2o.Connection;

import java.util.List;

public interface IUser {
    Users getUser(Connection connection, int id);
    Users getAllUsers(Connection connection);
    List<Users> getAllUsersByDepartmentId(Connection connection, int departmentId);
    boolean createUser(Connection connection, Users user);
    boolean updateUser(Connection connection, Users user);
    boolean deleteUser(Connection connection, int id);
}
