package com.example.govert.friendsr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

public class FriendsAdapter extends ArrayAdapter<Friend> {
    private List<Friend> friends;
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.grid_item, parent, false);
        }
        convertView.findViewById();
        return convertView;
    }

    public FriendsAdapter(Context context, int resource, List<Friend> objects) {
        this.friends = objects;
    }
}
