package com.dkhai.playsongservice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    private Button buttonPlay;
    private Button buttonStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonPlay = (Button) this.findViewById(R.id.button_play);
        buttonStop = (Button) this.findViewById(R.id.button_stop);

        buttonPlay.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                fn_playSong();
            }
        });

        buttonStop.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                fn_stopSong();
            }
        });
    }

    // This method is called when users click on the Play button.
    private void fn_playSong() {
        // Create Intent object for PlaySongService.
        Intent myIntent = new Intent(MainActivity.this, PlaySongService.class);
        // myIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        // Call startService with Intent parameter.
        this.startService(myIntent);
    }

    // This method is called when users click on the Stop button.
    private void fn_stopSong() {
        // Create Intent object
        Intent myIntent = new Intent(MainActivity.this, PlaySongService.class);
        this.stopService(myIntent);
    }
}