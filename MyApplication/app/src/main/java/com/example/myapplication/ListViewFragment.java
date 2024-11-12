package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

public class ListViewFragment extends Fragment {

    private ListView foodListView;
    private FoodAdapter adapter;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_view, container, false);

        foodListView = view.findViewById(R.id.food_list_view);
        adapter = new FoodAdapter(getActivity(), FoodDatabase.getInstance(getActivity()).foodDao().getAll());
        foodListView.setAdapter(adapter);

        foodListView.setOnItemClickListener((parent, view1, position, id) -> {
            FoodItem foodItem = adapter.getItem(position);
            ((MainActivity) getActivity()).navigateToUpdateFragment(foodItem);
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        adapter.updateData(FoodDatabase.getInstance(getActivity()).foodDao().getAll());
    }
}
