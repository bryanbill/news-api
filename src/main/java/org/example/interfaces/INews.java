package org.example.interfaces;

import org.example.models.News;
import org.sql2o.Connection;

public interface INews {
    News getNews(Connection connection, int id);

    News getAllNews(Connection connection);

    boolean createNews(Connection connection, News news);

    boolean updateNews(Connection connection, News news);

    boolean deleteNews(Connection connection, int id);
}
