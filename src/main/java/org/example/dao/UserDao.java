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
        try {
            return connection.createQuery("SELECT * FROM users WHERE id = :id ")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Users.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param connection
     * @return
     */
    @Override
    public List<Users> getAllUsers(Connection connection) {
        try {
            return connection.createQuery("SELECT * FROM users")
                    .executeAndFetch(Users.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param connection
     * @param departmentId
     * @return
     */
    @Override
    public List<Users> getAllUsersByDepartmentId(Connection connection, int departmentId) {
        try {
            return connection.createQuery("SELECT * FROM users WHERE departmentid = :departmentId")
                    .addParameter("departmentId", departmentId)
                    .executeAndFetch(Users.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param connection
     * @param user
     * @return
     */
    @Override
    public boolean createUser(Connection connection, Users user) {
        try {
            return connection.createQuery("INSERT INTO users(username,fullname,phone, email, " +
                            "departmentid, roles, position, address) " +
                            "VALUES (:username,  :fullName,:phone, :email,:departmentId,:roles, :position, :address)")
                    .bind(user)
                    .executeUpdate().getResult() > 0;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param connection
     * @param user
     * @return
     */
    @Override
    public boolean updateUser(Connection connection, Users user) {
        try {
          //  connection.getJdbcConnection().setAutoCommit(false);
            return connection.createQuery("UPDATE users SET username = :username, fullname = :fullName, " +
                            "phone = :phone, email = :email, departmentid = :departmentId, roles = :roles, " +
                            "position = :position, address = :address WHERE id = :id")
                    .bind(user)
                    .executeUpdate().getResult() > 0;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param connection
     * @param id
     * @return
     */
    @Override
    public boolean deleteUser(Connection connection, int id) {
        try {
            return connection.createQuery("DELETE FROM users WHERE id = :id")
                    .addParameter("id", id)
                    .executeUpdate().getResult() > 0;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
