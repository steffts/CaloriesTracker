package com.example.myapplication;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;


import java.io.Serializable;
public class UpdateAndDeleteFragment extends Fragment {

    private EditText foodNameInput, caloriesInput;
    private Button updateButton, deleteButton;
    private FoodItem foodItem;

    public static UpdateAndDeleteFragment newInstance(FoodItem foodItem) {
        UpdateAndDeleteFragment fragment = new UpdateAndDeleteFragment();
        Bundle args = new Bundle();
        args.putSerializable("foodItem", foodItem);
        fragment.setArguments(args);
        return fragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_update_and_delete, container, false);

        foodNameInput = view.findViewById(R.id.food_name_input);
        caloriesInput = view.findViewById(R.id.calories_input);
        updateButton = view.findViewById(R.id.update_button);
        deleteButton = view.findViewById(R.id.delete_button);

        if (getArguments() != null) {
            foodItem = (FoodItem) getArguments().getSerializable("foodItem");
            foodNameInput.setText(foodItem.getName());
            caloriesInput.setText(String.valueOf(foodItem.getCalories()));
        }

        updateButton.setOnClickListener(v -> updateFoodItem());
        deleteButton.setOnClickListener(v -> deleteFoodItem());

        return view;
    }

    private void updateFoodItem() {
        String foodName = foodNameInput.getText().toString();
        String caloriesText = caloriesInput.getText().toString();

        if (foodName.isEmpty() || caloriesText.isEmpty()) {
            Toast.makeText(getActivity(), "Please, fill out all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            int calories = Integer.parseInt(caloriesText);
            foodItem.setName(foodName);
            foodItem.setCalories(calories);
            FoodDatabase.getInstance(getActivity()).foodDao().update(foodItem);
            Toast.makeText(getActivity(), "Food is successfully refreshed!", Toast.LENGTH_SHORT).show();
            getActivity().getSupportFragmentManager().popBackStack();
        } catch (NumberFormatException e) {
            Toast.makeText(getActivity(), "Please, insert a valid value for calories", Toast.LENGTH_SHORT).show();
        }
    }

    private void deleteFoodItem() {
        FoodDatabase.getInstance(getActivity()).foodDao().delete(foodItem);
        Toast.makeText(getActivity(), "Food is successfully added!", Toast.LENGTH_SHORT).show();
        getActivity().getSupportFragmentManager().popBackStack();
    }
}

