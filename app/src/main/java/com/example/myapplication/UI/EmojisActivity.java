package com.example.myapplication.UI;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Data.Emoji;
import com.example.myapplication.R;
import com.example.myapplication.UI.Adapter.ListAdapter;

import java.util.ArrayList;

public class EmojisActivity extends AppCompatActivity {

    ListAdapter listAdapter;
    ArrayList<Emoji> dataArrayList = new ArrayList<>();
    Emoji emoji;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emojis);

        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.button);
        mediaPlayer.start();

        MediaPlayer mediaPlayer1 = MediaPlayer.create(this, R.raw.background_music);
        mediaPlayer1.setLooping(true);
        mediaPlayer1.start();

        ListView listView = findViewById(R.id.listview);

        int[] nameList = {R.string.cold_face, R.string.crying_face, R.string.fearful_face, R.string.hot_face, R.string.hugging_face, R.string.laughing_face, R.string.pleading_face, R.string.pouting_face, R.string.screaming_face, R.string.shushing_face};
        int[] descriptionList = {R.string.coldDescription, R.string.cryingDescription, R.string.fearfulDescription, R.string.hotDescription, R.string.huggingDescription, R.string.laughingDescription, R.string.pleadingDescription, R.string.poutingDescription, R.string.screamingDescription, R.string.shushingDescription};
        int[] imageList = {R.drawable.cold_face_svgrepo_com, R.drawable.crying_face_svgrepo_com, R.drawable.fearful_face_svgrepo_com, R.drawable.hot_face_svgrepo_com, R.drawable.hugging_face_svgrepo_com, R.drawable.rolling_on_the_floor_laughing_svgrepo_com, R.drawable.pleading_face_svgrepo_com, R.drawable.pouting_face_svgrepo_com, R.drawable.face_screaming_in_fear_svgrepo_com, R.drawable.shushing_face_svgrepo_com};

        for (int i = 0; i < imageList.length; i++){
            emoji = new Emoji(nameList[i], descriptionList[i], imageList[i]);
            dataArrayList.add(emoji);
        }
        listAdapter = new ListAdapter(this, dataArrayList);
        listView.setAdapter(listAdapter);
        listView.setClickable(true);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(EmojisActivity.this, DetailsActivity.class);
                intent.putExtra("name", nameList[i]);
                intent.putExtra("description", descriptionList[i]);
                intent.putExtra("image", imageList[i]);
                startActivity(intent);
            }
        });
    }

}
