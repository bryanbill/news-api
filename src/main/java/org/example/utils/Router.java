package org.example.utils;

import com.google.gson.Gson;
import org.example.dao.DepartmentsDao;
import org.example.dao.NewsDao;
import org.example.dao.UserDao;
import org.example.models.Departments;
import org.example.models.News;
import org.example.models.Users;
import org.sql2o.Connection;
import static spark.Spark.*;

public class Router {
    public static void run(Connection connection) {
        get("/users", (req, res) -> {
            Gson gson = new Gson();
            return gson.toJson(new UserDao().getAllUsers(connection));
        });

        get("/users/:id", (req, res) -> {
            Gson gson = new Gson();
            return gson.toJson(new UserDao().getUser(connection, Integer.parseInt(req.params(":id"))));
        });

        get("/departments/:id/news", (req, res) -> {
            Gson gson = new Gson();
            return gson.toJson(new NewsDao().getAllNewsByDepartmentId(connection, Integer.parseInt(req.params(":id"))));
        });

        get("/departments/:id", (req, res) -> {
            Gson gson = new Gson();
            return gson.toJson(new DepartmentsDao().getDepartment(connection, Integer.parseInt(req.params(":id"))));
        });

        get("/departments", (req, res) -> {
            Gson gson = new Gson();
            return gson.toJson(new DepartmentsDao().getAllDepartments(connection));
        });

        get("/news/:id", (req, res) -> {
            Gson gson = new Gson();
            return gson.toJson(new NewsDao().getNews(connection, Integer.parseInt(req.params(":id"))));
        });

        get("/news", (req, res) -> {
            Gson gson = new Gson();
            return gson.toJson(new NewsDao().getAllNews(connection));
        });

        post("/users", (req, res) -> {
            Gson gson = new Gson();
            Users user = gson.fromJson(req.body(), Users.class);
            return gson.toJson(new UserDao().createUser(connection, user));
        });

        put("/users/:id", (req, res) -> {
            Gson gson = new Gson();
            Users user = gson.fromJson(req.body(), Users.class);
            user.setId(Integer.parseInt(req.params(":id")));
            return gson.toJson(new UserDao().updateUser(connection, user));
        });

        delete("/users/:id", (req, res) -> {
            Gson gson = new Gson();
            return gson.toJson(new UserDao().deleteUser(connection, Integer.parseInt(req.params(":id"))));
        });

        post("/news", (req, res) -> {
            Gson gson = new Gson();
            return gson.toJson(new NewsDao().createNews(connection,
                    gson.fromJson(req.body(), News.class)));
        });

        put("/news/:id", (req, res) -> {
            Gson gson = new Gson();
            News news = gson.fromJson(req.body(), News.class);
            news.setId(Integer.parseInt(req.params(":id")));
            return gson.toJson(new NewsDao().updateNews(connection, news));
        });

        delete("/news/:id", (req, res) -> {
            Gson gson = new Gson();
            return gson.toJson(new NewsDao().deleteNews(connection, Integer.parseInt(req.params(":id"))));
        });

        post("/departments", (req, res) -> {
            Gson gson = new Gson();
            return gson.toJson(new DepartmentsDao().createDepartment(connection,
                    gson.fromJson(req.body(), Departments.class)));
        });

        put("/departments/:id", (req, res) -> {
            Gson gson = new Gson();
            Departments department = gson.fromJson(req.body(), Departments.class);
            department.setId(Integer.parseInt(req.params(":id")));
            return gson.toJson(new DepartmentsDao().updateDepartment(connection, department));
        });

        delete("/departments/:id", (req, res) -> {
            Gson gson = new Gson();
            return gson.toJson(new DepartmentsDao().deleteDepartment(connection,
                    Integer.parseInt(req.params(":id"))));
        });


    }
}
