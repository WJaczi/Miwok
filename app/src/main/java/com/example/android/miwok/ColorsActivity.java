/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word>  words = new ArrayList<Word>();

        words.add(new Word("red", "wetetti"));
        words.add(new Word("green", "chokokki"));
        words.add(new Word("brown", "takaakki"));
        words.add(new Word("gray", "oyyisa"));
        words.add(new Word("black", "massokka"));
        words.add(new Word("white", "temmokka"));
        words.add(new Word("dusty yellow", "kenekaku"));
        words.add(new Word("mustard yellow", "kawinta"));

        WordAdapter itemsAdapter = new WordAdapter(this, words);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);


//        LinearLayout rootView = (LinearLayout) findViewById(R.id.rootView);
//
//
//        for(int index = 0;index<words.size(); index++){
//
//            TextView wordView = new TextView(this);
//            wordView.setText(words.get(index));
//            rootView.addView(wordView);
//
//        }





        // Log.v("NumbersActivity", "Word at index 0: " + words.get(0));



    }
}
