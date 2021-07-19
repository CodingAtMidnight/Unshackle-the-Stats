package com.example.unshackledemstats;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.unshackledemstats.Champions.ZedActivity;

public class StatsPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats_page);


        ImageView zedIcon = findViewById(R.id.zed);
        zedIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(StatsPage.this, ZedActivity.class);
                startActivity(i);

                finish();
            }
        });
    }
}