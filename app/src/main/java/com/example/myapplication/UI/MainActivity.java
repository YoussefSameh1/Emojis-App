package com.example.myapplication.UI;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.background_music);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();

    }

    public void openEmojisTap(View view){
        Intent intent = new Intent(this,EmojisActivity.class);
        startActivity(intent);
    }
}