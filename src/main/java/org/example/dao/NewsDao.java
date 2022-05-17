package org.example.dao;

import org.example.interfaces.INews;
import org.example.models.News;
import org.example.models.Users;
import org.sql2o.Connection;
import org.sql2o.Sql2oException;

import java.util.List;

public class NewsDao implements INews {
    /**
     * @param connection
     * @param id
     * @return
     */
    @Override
    public News getNews(Connection connection, int id) {
        try {
            String sql = "SELECT * FROM news WHERE id = :id";
            return connection.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(News.class);
        } catch (Sql2oException ex) {
            throw new Sql2oException("Could not get news with id " + id, ex);
        }
    }

    /**
     * @param connection
     * @return
     */
    @Override
    public List<News> getAllNews(Connection connection) {
        try {
            String sql = "SELECT * FROM news";
            return connection.createQuery(sql)
                    .executeAndFetch(News.class);
        } catch (Sql2oException ex) {
            throw new Sql2oException("Could not get all news", ex);
        }
    }

    /**
     * @param connection
     * @param departmentId
     * @return
     */
    @Override
    public List<News> getAllNewsByDepartmentId(Connection connection, int departmentId) {
        try {
            String sql = "SELECT * FROM news WHERE departmentid = :departmentId";
            return connection.createQuery(sql)
                    .addParameter("departmentId", departmentId)
                    .executeAndFetch(News.class);
        } catch (Sql2oException ex) {
            throw new Sql2oException("Could not get all news by department id " + departmentId, ex);
        }
    }

    /**
     * @param connection 
     * @param id
     * @return
     */
    @Override
    public List<Users> getDepartmentUsers(Connection connection, int id) {
        try {
            String sql = "SELECT * FROM users WHERE departmentid = :id";
            return connection.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetch(Users.class);
        } catch (Sql2oException ex) {
            throw new Sql2oException("Could not get all users by department id " + id, ex);
        }
    }

    /**
     * @param connection
     * @param news
     * @return
     */
    @Override
    public boolean createNews(Connection connection, News news) {
        try {
            String sql = "INSERT INTO news (departmentid, content) VALUES (:departmentId, :content)";
            return connection.createQuery(sql)
                    .bind(news)
                    .executeUpdate()
                    .getResult() > 0;

        } catch (Sql2oException ex) {
            throw new Sql2oException("Could not create news", ex);
        }
    }

    /**
     * @param connection
     * @param news
     * @return
     */
    @Override
    public boolean updateNews(Connection connection, News news) {
        try {
            String sql = "UPDATE news SET departmentid = :departmentId, content = :content WHERE id = :id";
            return connection.createQuery(sql)
                    .bind(news)
                    .executeUpdate()
                    .getResult() > 0;
        } catch (Sql2oException ex) {
            throw new Sql2oException("Could not update news", ex);
        }
    }

    /**
     * @param connection
     * @param id
     * @return
     */
    @Override
    public boolean deleteNews(Connection connection, int id) {
        try {
            String sql = "DELETE FROM news WHERE id = :id";
            return connection.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate()
                    .getResult() > 0;

        } catch (Sql2oException ex) {
            throw new Sql2oException("Could not delete news with id " + id, ex);
        }
    }
}
