package com.example.spacex;

import androidx.room.RoomDatabase;

@androidx.room.Database(entities = {Country.class},version = 1)
public abstract class Database extends RoomDatabase {
    public abstract com.example.spacex.Dao dao();
}
