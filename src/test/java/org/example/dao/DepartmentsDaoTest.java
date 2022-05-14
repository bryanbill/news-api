package org.example.dao;

import org.example.database.Db;
import org.example.database.DbImpl;
import org.example.database.Seeder;
import org.example.models.Departments;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentsDaoTest {
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
    void getDepartment() {
        try {
            DepartmentsDao departmentsDao = new DepartmentsDao();
            departmentsDao.createDepartment(db.connect(), new Departments("test", "test"));
            assertTrue(departmentsDao.getDepartment(db.connect(), 1).getDescription().equals("test"));
        } catch (Exception e) {
            fail("Test failed", e);
        }
    }

    @Test
    void getAllDepartments() {
        try {
            DepartmentsDao departmentsDao = new DepartmentsDao();
            departmentsDao.createDepartment(db.connect(), new Departments("test", "test"));
            List<Departments> departments = departmentsDao.getAllDepartments(db.connect());
            assertTrue(departments.size() == 1);
        } catch (Exception e) {
            fail("Test failed", e);
        }
    }

    @Test
    void createDepartment() {
        try {
            DepartmentsDao departmentsDao = new DepartmentsDao();
            assertTrue(departmentsDao.
                    createDepartment(db.connect(),
                            new Departments("test", "test"))
            );
        } catch (Exception e) {
            fail("Test failed", e);
        }
    }

    @Test
    void updateDepartment() {
        try {
            DepartmentsDao departmentsDao = new DepartmentsDao();
            departmentsDao.createDepartment(db.connect(), new Departments("test", "test"));
            Departments departments = new Departments("test", "test2");
            departments.setId(1);
            departments.setEmployeeCount(20);
            assertFalse(departmentsDao.
                    updateDepartment(db.connect(),
                            new Departments("test", "test"))
            );
        } catch (Exception e) {
            fail("Test failed", e);
        }
    }

    @Test
    void deleteDepartment() {
        try {
            DepartmentsDao departmentsDao = new DepartmentsDao();
            departmentsDao.createDepartment(db.connect(), new Departments("test", "test"));
            assertTrue(departmentsDao.deleteDepartment(db.connect(), 1));
        } catch (Exception e) {
            fail("Test failed", e);
        }
    }
}