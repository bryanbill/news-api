package org.example.dao;

import org.example.interfaces.INews;
import org.example.models.News;
import org.sql2o.Connection;

import java.util.List;

public class NewsDao implements INews {
    /**
     * @param connection 
     * @param id
     * @return
     */
    @Override
    public News getNews(Connection connection, int id) {
        return null;
    }

    /**
     * @param connection 
     * @return
     */
    @Override
    public List<News> getAllNews(Connection connection) {
        return null;
    }

    /**
     * @param connection 
     * @param departmentId
     * @return
     */
    @Override
    public List<News> getAllNewsByDepartmentId(Connection connection, int departmentId) {
        return null;
    }

    /**
     * @param connection 
     * @param news
     * @return
     */
    @Override
    public boolean createNews(Connection connection, News news) {
        return false;
    }

    /**
     * @param connection 
     * @param news
     * @return
     */
    @Override
    public boolean updateNews(Connection connection, News news) {
        return false;
    }

    /**
     * @param connection 
     * @param id
     * @return
     */
    @Override
    public boolean deleteNews(Connection connection, int id) {
        return false;
    }
}
