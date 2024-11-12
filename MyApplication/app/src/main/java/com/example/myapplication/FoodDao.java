package com.example.myapplication;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface FoodDao {
    @Insert
    void insert(FoodItem foodItem);

    @Update
    void update(FoodItem foodItem);

    @Delete
    void delete(FoodItem foodItem);

    @Query("SELECT * FROM FoodItem")
    List<FoodItem> getAll();
}
