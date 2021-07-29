package com.example.unshackledemstats;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.unshackledemstats.Champions.ZedActivity;
import com.example.unshackledemstats.database.entryDatabase;
import com.example.unshackledemstats.entities.gameEntrie;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MatchHistoryDisplay extends AppCompatActivity{
    private List<gameEntrie> gameEntrieList;
     private EntryListAdapter entryListAdapter;
     private EntryListAdapter.RecyclerViewClickListener listener;
    public static final int REQUEST_CODE_UPDATE_NOTE = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_history_display);
        Button addGameButton = findViewById(R.id.addGameButton);
        Button clearAll = findViewById(R.id.clearButton);





        clearAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteAllEntries();
            }
        });

        addGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivityForResult(
                       new Intent(
                               MatchHistoryDisplay.this,
                               StatsPage.class
                       ), 100
               );
            }
        });



        initRecyclerView();
        loadEntriesList();
    }



    private void initRecyclerView() {
        setOnClickListener();
        RecyclerView recyclerView = findViewById(R.id.userRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        entryListAdapter = new EntryListAdapter(this, listener);
        recyclerView.setAdapter(entryListAdapter);
    }

    private void setOnClickListener() {
        entryDatabase db = entryDatabase.getEntryInstance(this.getApplicationContext());
        gameEntrieList = db.entryDao().getAllEntries();
        listener = new EntryListAdapter.RecyclerViewClickListener() {

            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(getApplicationContext(), ZedActivity.class);
               Bundle bundle = new Bundle();
               bundle.putString("creepScore", String.valueOf(gameEntrieList.get(position).getCreepScore()));
               bundle.putString("gameDeaths",String.valueOf(gameEntrieList.get(position).getGameDeaths()));
               bundle.putString("gameKills", String.valueOf(gameEntrieList.get(position).getGameKills()));
               bundle.putString("visionScore", String.valueOf(gameEntrieList.get(position).getVisionScore()));
               bundle.putString("gameNotes", gameEntrieList.get(position).getGameNotes());
               bundle.putString("reflectionNotes", gameEntrieList.get(position).getReflectionNotes());
               bundle.putString("bundleVodNotes", gameEntrieList.get(position).getVodNotes());
               intent.putExtras(bundle);
                startActivityForResult(intent, REQUEST_CODE_UPDATE_NOTE);
            }
        };
    }


    private void loadEntriesList() {
        setOnClickListener();
        entryDatabase db = entryDatabase.getEntryInstance(this.getApplicationContext());
        List<gameEntrie> gameEntryList = db.entryDao().getAllEntries();
        entryListAdapter.setGameEntrieList(gameEntryList);
    }

    private void deleteAllEntries() {
        entryDatabase db = entryDatabase.getEntryInstance(this.getApplicationContext());
        db.entryDao().deleteAll();
        recreate();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 100) {
            loadEntriesList();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}