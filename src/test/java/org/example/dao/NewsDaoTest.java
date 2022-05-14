package org.example.dao;

import org.example.database.Db;
import org.example.database.DbImpl;
import org.example.database.Seeder;
import org.example.interfaces.INews;
import org.example.models.News;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NewsDaoTest {
    private Db db;

    @BeforeEach
    void setUp() {
        db = new DbImpl();
        Seeder.seed(db.connect());
    }

    @AfterEach
    void tearDown() {
        Seeder.drop(db.connect());
    }

    @Test
    void getNews() {
        INews news = new NewsDao();
        news.createNews(db.connect(), new News(1, "News 1"));
        assertTrue(news.getNews(db.connect(), 1).getId() == 1);
    }

    @Test
    void getAllNews() {
        INews news = new NewsDao();
        news.createNews(db.connect(), new News(1, "News 1"));
        news.createNews(db.connect(), new News(2, "News 2"));
        assertEquals(2, news.getAllNews(db.connect()).size());
    }

    @Test
    void getAllNewsByDepartmentId() {
        INews news = new NewsDao();
        news.createNews(db.connect(), new News(1, "News 1"));
        news.createNews(db.connect(), new News(1, "News 2"));
        assertEquals(2, news.getAllNewsByDepartmentId(db.connect(), 1).size());
    }

    @Test
    void createNews() {
        INews news = new NewsDao();
        assertTrue(news.createNews(db.connect(), new News(1, "News 1")));
    }

    @Test
    void updateNews() {
        INews news = new NewsDao();
        News n = new News(1, "News 1");
        news.createNews(db.connect(), n);
        assertFalse(news.updateNews(db.connect(), new News(1, "News 2")));
    }

    @Test
    void deleteNews() {
        INews news = new NewsDao();
        News n = new News(1, "News 1");
        news.createNews(db.connect(), n);
        n.setId(1);
        assertTrue(news.deleteNews(db.connect(), 1));
    }
}