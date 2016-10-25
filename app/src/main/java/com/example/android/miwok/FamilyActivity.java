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

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    private AudioManager.OnAudioFocusChangeListener mAudiolistener = new AudioManager.OnAudioFocusChangeListener() {

        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK) {
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                mMediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                releaseMediaPlayer();
                // Stop playback
            }


        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        mAudioManager = (AudioManager) this.getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Word>  words = new ArrayList<Word>();

        words.add(new Word("father", "lutti", R.drawable.family_father, R.raw.family_father));
        words.add(new Word("mother", "otiiko", R.drawable.family_mother, R.raw.family_mother));
        words.add(new Word("daughter", "tolookosu", R.drawable.family_daughter, R.raw.family_daughter));
        words.add(new Word("older brother", "oyyisa", R.drawable.family_older_brother,R.raw.family_older_brother));
        words.add(new Word("younger brother", "massokka", R.drawable.family_younger_brother,R.raw.family_younger_brother));
        words.add(new Word("older sister", "temmokka", R.drawable.family_older_sister, R.raw.family_older_sister));
        words.add(new Word("younger sister", "kenekaku", R.drawable.family_younger_sister, R.raw.family_younger_sister));
        words.add(new Word("grandmother", "kawinta", R.drawable.family_grandmother, R.raw.family_grandmother));
        words.add(new Word("grandfather", "wo'e", R.drawable.family_grandfather, R.raw.family_grandfather));


        WordAdapter itemsAdapter = new WordAdapter(this, words,R.color.category_family);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word word = words.get(i);
                releaseMediaPlayer();

                int result = mAudioManager.requestAudioFocus(mAudiolistener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {


                    mMediaPlayer = MediaPlayer.create(FamilyActivity.this, word.getSoundId());
                    mMediaPlayer.start();
                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                }
            }
        });

    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
// If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
// Regardless of the current state of the media player, release its resources
// because we no longer need it.
            mMediaPlayer.release();
// Set the media player back to null. For our code, we've decided that
// setting the media player to null is an easy way to tell that the media player
// is not configured to play an audio file at the moment.
            mMediaPlayer = null;

            mAudioManager.abandonAudioFocus(mAudiolistener);
        }
    }
}