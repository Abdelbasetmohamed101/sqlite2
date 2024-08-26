package com.example.sqlite2;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
// MainActivity.java
public class MainActivity extends AppCompatActivity {

    ListView listViewUsers;
    DatabaseHelper databaseHelper;
    List<User> userList;
    UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewUsers = findViewById(R.id.listViewUsers);
        databaseHelper = new DatabaseHelper(this);
        userList = new ArrayList<>();

        // Fetch data from SQLite database
        Cursor cursor = databaseHelper.getAllUsers();
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String username = cursor.getString(1);
            String password = cursor.getString(2);
            userList.add(new User(id, username, password));
        }

        // Set up the adapter
        userAdapter = new UserAdapter(this, R.layout.user_item, userList);
        listViewUsers.setAdapter(userAdapter);
    }
}
