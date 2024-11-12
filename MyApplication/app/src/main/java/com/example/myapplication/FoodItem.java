package com.example.myapplication;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class FoodItem implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private int calories;


    public FoodItem(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }
}
