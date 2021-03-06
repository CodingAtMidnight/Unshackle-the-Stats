package com.example.unshackledemstats.Champions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.unshackledemstats.R;
import com.example.unshackledemstats.StatsPage;
import com.example.unshackledemstats.database.entryDatabase;
import com.example.unshackledemstats.entities.gameEntrie;

public class ZedActivity extends AppCompatActivity {

    private EditText creepScore, gameDeaths, gameKills, visionScore, gameNotes, reflectionNotes, vodNotes;
    private TextView battleTitle;
    private String backColor;
    private gameEntrie alreadyAvailableNote;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zed);

        battleTitle = findViewById(R.id.battleTitle);
        creepScore = findViewById(R.id.editTextNumber);
        gameDeaths = findViewById(R.id.editTextNumber2);
        gameKills = findViewById(R.id.editTextNumber3);
        visionScore = findViewById(R.id.editTextNumber4);
        gameNotes = findViewById(R.id.editTextTextPersonName2);
        reflectionNotes = findViewById(R.id.learned);
        vodNotes = findViewById(R.id.vodInput);
        Button inputGameButton = findViewById(R.id.addGameButton);
        Button winButton = findViewById(R.id.buttonWin);
        Button loseButton = findViewById(R.id.buttonLose);

        winButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              backColor = "#A1FCDF";
            }
        });

        loseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backColor = "#CE4257";
            }
        });

        inputGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNewEntry(creepScore.getText().toString(), gameDeaths.getText().toString(), gameKills.getText().toString(),
                        visionScore.getText().toString(), gameNotes.getText().toString(), reflectionNotes.getText().toString(),
                        vodNotes.getText().toString(),battleTitle.getText().toString(),backColor);
            }


        });


      bundleCreator();

    }

    public void bundleCreator() {
        Intent intent = getIntent();

//       String creepScoress = intent.getStringExtra("creepScore");
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            String name = bundle.getString("creepScore");
            String deaths = bundle.getString("gameDeaths");
            String kills = bundle.getString("gameKills");
            String visionScores = bundle.getString("visionScore");
            String bundledGameNotes = bundle.getString("gameNotes");
            String bundledReflectionNotes = bundle.getString("reflectionNotes");
            String bundledVodNotes = bundle.getString("bundleVodNotes");




            gameKills.setText(kills);
            gameDeaths.setText(deaths);
            creepScore.setText(name);
            visionScore.setText(visionScores);
            gameNotes.setText(bundledGameNotes);
            reflectionNotes.setText(bundledReflectionNotes);
            vodNotes.setText(bundledVodNotes);
        }
    }

    private void saveNewEntry(String creepScores, String gameDeaths, String gameKills, String visionScore, String gameNotes, String reflectionNotes, String vodNotes, String battleTitle, String backColor) {
        entryDatabase db = entryDatabase.getEntryInstance(this.getApplicationContext());

        gameEntrie gameEntrie = new gameEntrie();
        gameEntrie.setCreepScore(Integer.parseInt(String.valueOf(creepScores)));
        gameEntrie.setGameDeaths(Integer.parseInt(String.valueOf(gameDeaths)));
        gameEntrie.setGameKills(Integer.parseInt(String.valueOf(gameKills)));
        gameEntrie.setVisionScore(Integer.parseInt(String.valueOf(visionScore)));
        gameEntrie.setGameNotes(gameNotes);
        gameEntrie.setReflectionNotes(reflectionNotes);
        gameEntrie.setVodNotes(vodNotes);
        gameEntrie.setMatchUp(battleTitle);
        gameEntrie.setColor(backColor);
        db.entryDao().insertEntry(gameEntrie);

        finish();
    }
}