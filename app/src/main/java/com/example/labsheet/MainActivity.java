package com.example.labsheet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button start, stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MediaPlayer player = MediaPlayer.create(this, Settings.System.DEFAULT_NOTIFICATION_URI);
        player.setLooping(true);
        player.start();

        start.findViewById(R.id.btnStart);
        stop.findViewById(R.id.btnStop);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService(new Intent(MainActivity.this, MyServices.class));

            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopService(new Intent(MainActivity.this, MyServices.class));
            }
        });
    }
}