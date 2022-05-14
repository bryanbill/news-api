package org.example.database;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.sql2o.Sql2oException;

import static org.junit.jupiter.api.Assertions.*;

class SeederTest {

    private Db db = new DbImpl();

    @AfterEach
    void tearDown() {
        Seeder.drop(db.connect());
    }

    @Test
    void seed() {
        try{
           assertDoesNotThrow(() -> {
               Seeder.seed(db.connect());
           });
        } catch (Sql2oException e) {
            fail("Error connecting to database");
        }
    }
}