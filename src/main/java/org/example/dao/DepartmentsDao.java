package org.example.dao;

import org.example.interfaces.IDepartment;
import org.example.models.Departments;
import org.sql2o.Connection;

import java.util.List;

public class DepartmentsDao implements IDepartment {
    /**
     * @param connection
     * @param id
     * @return
     */
    @Override
    public Departments getDepartment(Connection connection, int id) {
        try {
            return connection.createQuery("SELECT * FROM departments WHERE id = :id ")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Departments.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * @param connection
     * @return
     */
    @Override
    public List<Departments> getAllDepartments(Connection connection) {
        try {
            return connection.createQuery("SELECT * FROM departments")
                    .executeAndFetch(Departments.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param connection
     * @param department
     * @return
     */
    @Override
    public boolean createDepartment(Connection connection, Departments department) {
        try {
            return connection.createQuery("INSERT INTO departments (departmentname, description)" +
                            " VALUES (:departmentName, :description)")
                    .bind(department)
                    .executeUpdate().getResult() > 0;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param connection
     * @param department
     * @return
     */
    @Override
    public boolean updateDepartment(Connection connection, Departments department) {
        try {
            return connection.createQuery("UPDATE departments SET employeeCount = :count WHERE id = :id")
                    .bind(department)
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
    public boolean deleteDepartment(Connection connection, int id) {
        try {
            return connection.createQuery("DELETE FROM departments WHERE id = :id")
                    .addParameter("id", id)
                    .executeUpdate().getResult() > 0;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
