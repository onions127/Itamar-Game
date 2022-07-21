package com.example.itamargame;

import android.content.Context;
import android.media.MediaPlayer;

public class CommonMethod {
    public static MediaPlayer player;
    public static void SoundPlayer(Context ctx){
        player = MediaPlayer.create(ctx, R.raw.hayday);
        player.setLooping(true); // Set looping
        player.setVolume(30, 30);

        //player.release();
        player.start();
    }
}
