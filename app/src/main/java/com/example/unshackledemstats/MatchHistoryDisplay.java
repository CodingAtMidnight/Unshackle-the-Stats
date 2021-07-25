package com.example.unshackledemstats;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.unshackledemstats.Champions.ZedActivity;
import com.example.unshackledemstats.database.entryDatabase;
import com.example.unshackledemstats.entities.gameEntrie;

import java.util.List;

public class MatchHistoryDisplay extends AppCompatActivity {

    private EntryListAdapter entryListAdapter;

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
        RecyclerView recyclerView = findViewById(R.id.userRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        entryListAdapter = new EntryListAdapter(this);
        recyclerView.setAdapter(entryListAdapter);
    }


    private void loadEntriesList() {
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