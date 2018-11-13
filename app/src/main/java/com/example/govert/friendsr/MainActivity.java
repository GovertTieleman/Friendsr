package com.example.govert.friendsr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // set gridView
        GridView gridView = (GridView) findViewById(R.id.friends_list);

        // initialize friendsList
        ArrayList<Friend> friendsList = new ArrayList<>();

        // add friends
        friendsList.add(new Friend("Arya", "Not a boy.", R.drawable.arya));
        friendsList.add(new Friend("Cersei", "Evil, but loves her children.", R.drawable.cersei));
        friendsList.add(new Friend("Daenerys", "Mother of Dragons.", R.drawable.daenerys));
        friendsList.add(new Friend("Jaime", "Known as the Kingslayer.", R.drawable.jaime));
        friendsList.add(new Friend("Jon", "Too noble for his own good.", R.drawable.jon));
        friendsList.add(new Friend("Jorah", "Has a tragic love life.", R.drawable.jorah));
        friendsList.add(new Friend("Margaery", "Princess of Highgarden.", R.drawable.margaery));
        friendsList.add(new Friend("Melisandre", "Loyal servant of the Lord of Light.", R.drawable.melisandre));
        friendsList.add(new Friend("Sansa", "Lady of Winterfell.", R.drawable.sansa));
        friendsList.add(new Friend("Tyrion", "His wit and cunning make up for his dwarfish posture.", R.drawable.tyrion));

        // get SharedPreferences to set ratings
        SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);

        // set ratings
        for (Friend f : friendsList) {
            // get rating for each friend
            float rating = prefs.getFloat(f.getName(), (float) 0);
            if (rating != 0) {
                // if stored rating exists, set rating
                f.setRating(rating);
            }
        }

        // pass friendsList to adapter to generate layout
        FriendsAdapter adapter = new FriendsAdapter(this, 0, friendsList);

        // set gridView to show layout
        gridView.setAdapter(adapter);

        // set listener for gridView
        gridView.setOnItemClickListener(new GridItemClickListener());
    }

    // activates when a GridItem is clicked
    private class GridItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            // make intent and include the instance of Friend class that was clicked
            Friend clickedFriend = (Friend) parent.getItemAtPosition(position);
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("clicked_friend", clickedFriend);

            // start ProfileActivity with intent
            startActivity(intent);
        }
    }
}
