package com.example.myapplication.UI;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;


public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.button);
        mediaPlayer.start();

        MediaPlayer mediaPlayer1 = MediaPlayer.create(this, R.raw.background_music);
        mediaPlayer1.setLooping(true);
        mediaPlayer1.start();

        TextView detailName = findViewById(R.id.emojiName);
        TextView detailDescription = findViewById(R.id.emojiDescription);
        ImageView detailImage = findViewById(R.id.emojiImage);

        Intent intent = this.getIntent();
        if (intent != null) {
            int name = intent.getIntExtra("name", R.string.cold_face);
            int description = intent.getIntExtra("description", R.string.cold_face);
            int image = intent.getIntExtra("image", R.drawable.cold_face_svgrepo_com);

            detailName.setText(name);
            detailDescription.setText(description);
            detailImage.setImageResource(image);
        }
    }

    public void back(View view) {
        Intent intent = new Intent(this, EmojisActivity.class);
        startActivity(intent);
    }
}
