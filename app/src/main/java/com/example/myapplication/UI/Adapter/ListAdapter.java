package com.example.myapplication.UI.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.example.myapplication.Data.Emoji;
import com.example.myapplication.R;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<Emoji> {
    public ListAdapter(Context context, ArrayList<Emoji> dataArrayList) {
        super(context, R.layout.list_item, dataArrayList);
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        Emoji emoji = getItem(position);

        if (view == null){
            view = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        ImageView listImage = view.findViewById(R.id.emoji);
        listImage.setImageResource(emoji.image);

        return view;
    }
}