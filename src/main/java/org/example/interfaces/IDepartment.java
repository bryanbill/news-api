package org.example.interfaces;

import org.example.models.Departments;
import org.sql2o.Connection;

public interface IDepartment {
    Departments getDepartment(Connection connection, int id);

    Departments getAllDepartments(Connection connection);

    boolean createDepartment(Connection connection, Departments department);

    boolean updateDepartment(Connection connection, Departments department);

    boolean deleteDepartment(Connection connection, int id);
}
