package org.example.interfaces;

import org.example.models.News;
import org.sql2o.Connection;

import java.util.List;

public interface INews {
    News getNews(Connection connection, int id);

    List<News> getAllNews(Connection connection);

    List<News> getAllNewsByDepartmentId(Connection connection, int departmentId);

    boolean createNews(Connection connection, News news);

    boolean updateNews(Connection connection, News news);

    boolean deleteNews(Connection connection, int id);
}
