package com.example.govert.friendsr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FriendsAdapter extends ArrayAdapter<Friend> {
    // initialize friendslist
    private List<Friend> friendsList;

    public FriendsAdapter(Context context, int resource, List<Friend> objects) {
        super(context, resource, objects); // what does this do?

        // set friendsList
        friendsList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // set View gridItem to convertView
        View gridItem = convertView;

        // if convertView == null, inflate gridItem from grid_item.xml
        if (gridItem == null) {
            gridItem = LayoutInflater.from(getContext()).inflate(R.layout.grid_item, parent, false);
        }

        // get currentFriend
        Friend currentFriend = friendsList.get(position);

        // set image for currentFriend
        ImageView image = (ImageView) gridItem.findViewById(R.id.imageView_friend);
        image.setImageResource(currentFriend.getDrawableId());

        // set name for currentFriend
        TextView name = (TextView) gridItem.findViewById(R.id.textView_name);
        name.setText(currentFriend.getName());

        // return the loaded gridItem to MainActivity
        return gridItem;
    }
}
