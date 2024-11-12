package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class InsertFragment extends Fragment {

    private EditText foodNameInput, caloriesInput;
    private Button addButton;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_insert, container, false);

        foodNameInput = view.findViewById(R.id.food_name_input);
        caloriesInput = view.findViewById(R.id.calories_input);
        addButton = view.findViewById(R.id.add_button);

        addButton.setOnClickListener(v -> addFoodItem());

        return view;
    }

    private void addFoodItem() {
        String foodName = foodNameInput.getText().toString();
        String caloriesText = caloriesInput.getText().toString();

        if (foodName.isEmpty() || caloriesText.isEmpty()) {
            Toast.makeText(getActivity(), "Please, fill out all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            int calories = Integer.parseInt(caloriesText);
            FoodDatabase.getInstance(getActivity()).foodDao().insert(new FoodItem(foodName, calories));
            foodNameInput.setText("");
            caloriesInput.setText("");
            Toast.makeText(getActivity(), "Food is successfully added!", Toast.LENGTH_SHORT).show();
        } catch (NumberFormatException e) {
            Toast.makeText(getActivity(), "Please, insert a valid value for calories", Toast.LENGTH_SHORT).show();
        }
    }

}
