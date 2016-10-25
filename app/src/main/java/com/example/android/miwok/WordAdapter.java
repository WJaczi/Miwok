package com.example.android.miwok;


import android.app.Activity;
import android.media.MediaPlayer;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by w.jaczewska on 2016-10-10.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    private int mBackgound;

    public WordAdapter(Activity context, ArrayList<Word> words, int background) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, words);
        mBackgound = background;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Word currentWord = getItem(position);

        TextView miwokText = (TextView) listItemView.findViewById(R.id.text1);

        miwokText.setText(currentWord.getMiwokWord());

        TextView defaultText = (TextView) listItemView.findViewById(R.id.text2);

        defaultText.setText(currentWord.getDefaultWord());

        ImageView image = (ImageView) listItemView.findViewById(R.id.image);



        if(currentWord.hasImage()) {

            image.setImageResource(currentWord.getImageResourceId());
            image.setVisibility(View.VISIBLE);
        }

        else {
            image.setVisibility(View.GONE);
        }

        View textContainer = listItemView.findViewById(R.id.text_container);

        int color = ContextCompat.getColor(getContext(), mBackgound);

        textContainer.setBackgroundColor(color);

       // return super.getView(position, convertView, parent);
        return listItemView;
    }



}
