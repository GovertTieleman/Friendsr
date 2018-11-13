package com.example.govert.friendsr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private GridView gridView;
    private FriendsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = (GridView) findViewById(R.id.friends_list);
        ArrayList<Friend> friendsList = new ArrayList<>();
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

        adapter = new FriendsAdapter(this, 0, friendsList);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new GridItemClickListener());
    }

    private class GridItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Friend clickedFriend = (Friend) parent.getItemAtPosition(position);
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("clicked_friend", clickedFriend);
            startActivity(intent);
        }
    }
}
