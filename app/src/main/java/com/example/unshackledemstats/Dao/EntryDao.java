package com.example.unshackledemstats.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.unshackledemstats.entities.gameEntrie;

import java.util.List;

@Dao
public interface EntryDao {
    @Query("SELECT * FROM gameEntries")
    List<gameEntrie> getAllEntries();

    @Insert
    void insertEntry(gameEntrie...gameEntries);

    @Delete
    void deleteEntry(gameEntrie...gameEntries);

    @Query("DELETE FROM gameEntries")
    void deleteAll();
}
