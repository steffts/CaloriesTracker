package com.example.myapplication;

import android.content.Context;

import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.Update;

import java.util.List;

@Database(entities = {FoodItem.class}, version = 1)
public abstract class FoodDatabase extends RoomDatabase {
    private static FoodDatabase instance;
    public abstract FoodDao foodDao();

    public static synchronized FoodDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            FoodDatabase.class, "food_database")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
