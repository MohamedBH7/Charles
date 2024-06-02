package com.example.charles;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private int currentSong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initially, no song is selected
        currentSong = 0;
    }

    public void chooseEnglish(View view) {
        releaseMediaPlayer();
        currentSong = R.raw.eng;
        mediaPlayer = MediaPlayer.create(MainActivity.this, currentSong);
        System.out.println("English song selected");
    }

    public void chooseFrench(View view) {
        releaseMediaPlayer();
        currentSong = R.raw.france;
        mediaPlayer = MediaPlayer.create(MainActivity.this, currentSong);
        System.out.println("French song selected");
    }

    public void playMusic(View view) {
        if (mediaPlayer != null) {
            mediaPlayer.start();
            System.out.println("Playing music");
        }
    }

    public void pauseMusic(View view) {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
            System.out.println("Music paused");
        }
    }

    public void stopMusic(View view) {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            releaseMediaPlayer();
            System.out.println("Music stopped");
        }
    }

    private void releaseMediaPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        releaseMediaPlayer();
    }
}
