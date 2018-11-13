package com.example.govert.friendsr;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Intent intent = getIntent();
        Friend retrievedFriend = (Friend) intent.getSerializableExtra("clicked_friend");

        ImageView image = (ImageView) findViewById(R.id.profileImageView_friend);
        image.setImageResource(retrievedFriend.getDrawableId());

        RatingBar rating = (RatingBar) findViewById(R.id.ratingBar);
        rating.setRating(retrievedFriend.getRating());

        TextView name = (TextView) findViewById(R.id.profileTextView_name);
        name.setText(retrievedFriend.getName());

        TextView bio = (TextView) findViewById(R.id.profileTextView_bio);
        bio.setText(retrievedFriend.getBio());
    }
}
