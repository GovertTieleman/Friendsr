package com.example.govert.friendsr;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FriendsAdapter extends ArrayAdapter<Friend> {
    private List<Friend> friendsList;

    public FriendsAdapter(Context context, int resource, List<Friend> objects) {
        super(context, resource, objects);
        friendsList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View gridItem = convertView;

        if (gridItem == null) {
            gridItem = LayoutInflater.from(getContext()).inflate(R.layout.grid_item, parent, false);
        }

        Friend currentFriend =  friendsList.get(position);

        ImageView image = (ImageView) gridItem.findViewById(R.id.imageView_friend);
        image.setImageResource(currentFriend.getDrawableId());

        TextView name = (TextView) gridItem.findViewById(R.id.textView_name);
        name.setText(currentFriend.getName());

        return gridItem;
    }
}
