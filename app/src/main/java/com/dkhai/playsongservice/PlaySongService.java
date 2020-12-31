package com.dkhai.playsongservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import android.media.MediaPlayer;

public class PlaySongService extends Service {

    private MediaPlayer mediaPlayer;

    public PlaySongService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        // throw new UnsupportedOperationException("Not yet implemented");

        // This service is unbounded
        // So this method is never called.
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        // Create MediaPlayer object, to play your song.
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.music);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Play song.
        mediaPlayer.start();
        // return super.onStartCommand(intent, flags, startId);
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        // Release the resources
        mediaPlayer.release();
        super.onDestroy();
    }
}