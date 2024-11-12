# Calories Tracker App
An Android application for tracking daily calorie intake. This app allows users to add, view, update, and delete food items with corresponding calorie information. The app is designed to be simple and user-friendly, featuring multiple fragments and a single main activity to manage navigation.

## Features
Add Food Items: Users can add food items with a name and calorie count.
View Food List: Displays a list of all added food items.
Update and Delete: Users can update the details of a food item or delete it from the list.
Intuitive Navigation: The app uses a fragment-based layout, enabling smooth transitions between views.
Screens
Add Food Screen: A form to add new food items.
Food List Screen: Displays all food items, allowing users to select an item for editing or deletion.
Update and Delete Screen: Allows users to edit or delete selected food items.
## Technologies Used
Java: The core programming language for the app.
Android Fragments: To enable a modular and dynamic UI.
RecyclerView: For displaying the list of food items.
SQLite Database: Stores the food items and calorie information persistently.
## Project Structure
The project is structured with a main activity and three main fragments:

MainActivity.java: Manages fragment transactions and serves as the main entry point.
InsertFragment.java: Handles adding new food items.
ListViewFragment.java: Displays the list of food items.
UpdateAndDeleteFragment.java: Manages updates and deletions of existing food items.
## Usage
Adding a Food Item: Start on the Add Food Screen, enter the name and calorie count, and press "Add" to save the item.
Viewing and Selecting: Switch to the Food List Screen to see all added items. Tap on an item to open it in the Update and Delete Screen.
Updating or Deleting: Edit the selected food item and press "Update" to save changes, or "Delete" to remove it from the list. You will be navigated back to the main list automatically after each action.
## Future Enhancements
User Authentication: Allow users to create accounts and log in to manage their data.
History and Statistics: Track daily calorie intake trends over time.
Improved UI/UX: Add animations and enhanced layouts.
### Contributing
Feel free to fork the repository and submit pull requests. Contributions to improve the functionality or UI of the app are welcome!

### License
This project is licensed under the MIT License.
