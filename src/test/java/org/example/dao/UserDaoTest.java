package org.example.dao;

import org.example.database.Db;
import org.example.database.DbImpl;
import org.example.database.Seeder;
import org.example.interfaces.IUser;
import org.example.models.Users;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {
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
    void getUser() {
        try {
            IUser userDao = new UserDao();
            userDao.createUser(db.connect(), new Users("test", "test", 1,
                    "test", "test", "test", "test", "test"));
            Users user = userDao.getUser(db.connect(), 1);
            assertTrue(user.getUsername().equals("test"));
        } catch (Exception e) {
            fail("Test failed", e);
        }
    }

    @Test
    void getAllUsers() {
        try {
            IUser userDao = new UserDao();
            userDao.createUser(db.connect(), new Users("test", "test", 1,
                    "test", "test", "test", "test", "test"));
            List<Users> users = userDao.getAllUsers(db.connect());
            assertTrue(users.size() == 1);
        } catch (Exception e) {
            fail("Test failed", e);
        }
    }

    @Test
    void getAllUsersByDepartmentId() {
        try {
            IUser userDao = new UserDao();
            userDao.createUser(db.connect(), new Users("test", "test", 1,
                    "test", "test", "test", "test", "test"));
            List<Users> users = userDao.getAllUsersByDepartmentId(db.connect(), 1);
            assertTrue(users.size() == 1);
        } catch (Exception e) {
            fail("Test failed", e);
        }
    }

    @Test
    void createUser() {
        try {
            IUser userDao = new UserDao();
            assertTrue( userDao.createUser(db.connect(), new Users("test", "test", 1,
                    "test", "test", "test", "test", "test")));
        } catch (Exception e) {
            fail("Test failed", e);
        }
    }

    @Test
    void updateUser() {
        try {
            IUser userDao = new UserDao();
            userDao.createUser(db.connect(), new Users("test", "test", 1,
                    "test", "test", "test", "test", "test"));
            Users user = userDao.getUser(db.connect(), 1);

            userDao.updateUser(db.connect(), user);
            Users user2 = userDao.getUser(db.connect(), 1);
            assertFalse(user2.getUsername().equals("test2"));
        } catch (Exception e) {
            fail("Test failed", e);
        }
    }

    @Test
    void deleteUser() {
        try {
            IUser userDao = new UserDao();
            userDao.createUser(db.connect(), new Users("test", "test", 1,
                    "test", "test", "test", "test", "test"));
            assertTrue(userDao.deleteUser(db.connect(), 1));
        } catch (Exception e) {
            fail("Test failed", e);
        }
    }
}