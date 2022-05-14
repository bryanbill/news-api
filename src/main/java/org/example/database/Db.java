package org.example.database;

import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

public abstract class Db {
    public abstract Connection connect();

    public abstract void disconnect(Connection connection);
}

