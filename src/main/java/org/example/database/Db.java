package org.example.database;

import org.sql2o.Connection;

abstract class Db{
    public abstract Connection connect();
    public abstract void disconnect();
}

class  DbImpl extends Db{
    public  Connection connect(){
        return null;
    }
    public  void disconnect(){
    }
}