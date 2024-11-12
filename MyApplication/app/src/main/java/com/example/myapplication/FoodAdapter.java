package com.example.myapplication;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;

public class FoodAdapter extends BaseAdapter {

    private Context context;
    private List<FoodItem> foodItems;
    private LayoutInflater inflater;

    // Конструктор за инициализация на адаптера
    public FoodAdapter(Context context, List<FoodItem> foodItems) {
        this.context = context;
        this.foodItems = foodItems;
        this.inflater = LayoutInflater.from(context);
    }

    // Връща броя на елементите в списъка
    @Override
    public int getCount() {
        return foodItems.size();
    }

    // Връща елемента на определена позиция
    @Override
    public FoodItem getItem(int position) {
        return foodItems.get(position);
    }

    // Връща ID на елемента (използваме позицията като ID)
    @Override
    public long getItemId(int position) {
        return position;
    }

    // Създава изглед за всеки елемент в списъка
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        // Ако изгледът все още не е създаден, инициализирайте го
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_item_food, parent, false);
            holder = new ViewHolder();
            holder.foodNameTextView = convertView.findViewById(R.id.food_name);
            holder.caloriesTextView = convertView.findViewById(R.id.calories);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // Вземете текущия елемент от списъка и го задайте на TextView елементите
        FoodItem foodItem = getItem(position);
        holder.foodNameTextView.setText(foodItem.getName());
        holder.caloriesTextView.setText(String.valueOf(foodItem.getCalories()) + " ккал");

        return convertView;
    }

    // Метод за обновяване на данните в адаптера
    public void updateData(List<FoodItem> newFoodItems) {
        this.foodItems = newFoodItems;
        notifyDataSetChanged();
    }

    // Клас за оптимизация чрез ViewHolder
    private static class ViewHolder {
        TextView foodNameTextView;
        TextView caloriesTextView;
    }
}
