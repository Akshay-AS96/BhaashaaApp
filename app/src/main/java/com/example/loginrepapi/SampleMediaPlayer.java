package com.example.loginrepapi;

import android.media.MediaPlayer;
import android.util.Log;

import java.io.IOException;

public class SampleMediaPlayer {
    private MediaPlayer mediaPlayer;

    public void SampleMediaPlayer() {
    }

    public void playAudio(String Durl, final String Surl ) {
        if (mediaPlayer == null)
            mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(Durl);
            mediaPlayer.prepare();
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                  killMediaPlayer();
                   playAudio1(Surl);

                }
            });
        } catch (Exception e) {
            Log.e("AUDIOHTTPPLAYER", e.getMessage());

        }

    }
    public void playAudio1(String Surl) {
        if (mediaPlayer == null)
            mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(Surl);
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (Exception e) {
            Log.e("AUDIOHTTPPLAYER", e.getMessage());

        }

    }

    public void killMediaPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
