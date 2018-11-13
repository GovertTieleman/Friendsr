package com.example.govert.friendsr;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
    // initialize SharedPreferences editor
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // get retrievedFriend
        Friend retrievedFriend = (Friend) getIntent().getSerializableExtra("clicked_friend");

        // set SharedPreferences editor
        SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);
        editor = prefs.edit();

        // set image, rating, name and bio
        ImageView image = (ImageView) findViewById(R.id.profileImageView_friend);
        image.setImageResource(retrievedFriend.getDrawableId());

        RatingBar rating = (RatingBar) findViewById(R.id.ratingBar);
        rating.setRating(prefs.getFloat(retrievedFriend.getName(), (float) 0));

        TextView name = (TextView) findViewById(R.id.profileTextView_name);
        name.setText(retrievedFriend.getName());

        TextView bio = (TextView) findViewById(R.id.profileTextView_bio);
        bio.setText(retrievedFriend.getBio());

        // set listener for RatingBar
        rating.setOnRatingBarChangeListener(new RatingBarListener());
    }

    // activates when RatingBar is changed
    private class RatingBarListener implements RatingBar.OnRatingBarChangeListener {
        @Override
        public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
            // get retrievedFriend
            Friend retrievedFriend = (Friend) getIntent().getSerializableExtra("clicked_friend");

            // edit retrievedFriend rating
            editor.putFloat(retrievedFriend.getName(), rating);
            editor.apply();
        }
    }
}
