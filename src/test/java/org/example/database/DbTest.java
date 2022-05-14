package org.example.database;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.fail;

class DbTest {
    private Db db;

    @Test
    void connect() {
        try {
            assertDoesNotThrow(() -> {
               db = new DbImpl();
               db.connect();
            });
        } catch (Exception e) {
            fail("Exception thrown");
        }
    }

    @Test
    void disconnect() {
        try {
            assertDoesNotThrow(() -> {
                db = new DbImpl();
                db.disconnect(db.connect());
            });
        } catch (Exception e) {
            fail("Exception thrown");
        }
    }
}