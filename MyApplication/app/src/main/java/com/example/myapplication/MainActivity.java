package com.example.myapplication;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getSupportFragmentManager().beginTransaction()
                .replace(R.id.insert_container, new InsertFragment())
                .replace(R.id.list_container, new ListViewFragment())
                .commit();
    }


    public void navigateToUpdateFragment(FoodItem foodItem) {
        UpdateAndDeleteFragment fragment = UpdateAndDeleteFragment.newInstance(foodItem);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.insert_container, fragment)
                .addToBackStack(null)
                .commit();
    }
}
