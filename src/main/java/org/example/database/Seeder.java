package org.example.database;

import org.jetbrains.annotations.NotNull;
import org.sql2o.Connection;
import org.sql2o.Sql2oException;

public class Seeder {
    public static void seed(@NotNull Connection connection) {
        try {
            connection.createQuery("CREATE TABLE  IF NOT EXISTS " +
                            "users (id SERIAL PRIMARY KEY, username VARCHAR(255) NOT NULL," +
                            "fullname VARCHAR(255) NOT NULL, roles VARCHAR(255) NOT NULL," +
                            "email VARCHAR(255) NOT NULL, phone VARCHAR(255) NOT NULL," +
                            "position TEXT, departmentid INTEGER," +
                            "address VARCHAR(255) NOT NULL,  createdat TIMESTAMP DEFAULT " +
                            "CURRENT_TIMESTAMP, " +
                            "updatedat TIMESTAMP DEFAULT CURRENT_TIMESTAMP)")
                    .executeUpdate();

            connection.createQuery("CREATE TABLE IF NOT EXISTS " +
                            "departments( id serial PRIMARY KEY, departmentname VARCHAR(255), " +
                            "description TEXT, employeeCount INTEGER)")
                    .executeUpdate();

            connection.createQuery("CREATE TABLE IF NOT EXISTS " +
                    "news(id SERIAL PRIMARY KEY, departmentid INTEGER, " +
                    "content TEXT, createdat TIMESTAMP default CURRENT_TIMESTAMP, " +
                    "updatedat TIMESTAMP default CURRENT_TIMESTAMP)")
                    .executeUpdate();
        } catch (Sql2oException e) {
            System.out.println("Error connecting to database");
        }
    }

    public static void drop(@NotNull Connection connection) {
        try {
            connection.createQuery("DROP TABLE IF EXISTS users")
                    .executeUpdate();
            connection.createQuery("DROP TABLE IF EXISTS departments")
                    .executeUpdate();
            connection.createQuery("DROP TABLE IF EXISTS news")
                    .executeUpdate();
        } catch (Sql2oException e) {
            System.out.println("Error connecting to database");
        }
    }
}
