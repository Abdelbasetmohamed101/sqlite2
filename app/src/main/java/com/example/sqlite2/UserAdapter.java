package com.example.sqlite2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
// UserAdapter.java
public class UserAdapter extends ArrayAdapter<User> {

    private Context context;
    private int resource;
    private List<User> userList;

    public UserAdapter(Context context, int resource, List<User> userList) {
        super(context, resource, userList);
        this.context = context;
        this.resource = resource;
        this.userList = userList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(resource, null);

        TextView textViewUsername = view.findViewById(R.id.textViewUsername);
        TextView textViewPassword = view.findViewById(R.id.textViewPassword);

        User user = userList.get(position);
        textViewUsername.setText(user.getUsername());
        textViewPassword.setText(user.getPassword());

        return view;
    }
}
