package org.example.interfaces;

import org.example.models.Users;
import org.sql2o.Connection;

public interface IUser {
    Users getUser(Connection connection, int id);
    Users getAllUsers(Connection connection);
    boolean createUser(Connection connection, Users user);
    boolean updateUser(Connection connection, Users user);
    boolean deleteUser(Connection connection, int id);
}
