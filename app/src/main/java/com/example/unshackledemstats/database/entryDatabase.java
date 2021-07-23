package com.example.unshackledemstats.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.unshackledemstats.Dao.EntryDao;
import com.example.unshackledemstats.entities.gameEntrie;

@Database(entities = {gameEntrie.class}, version = 2, exportSchema = false)
public abstract class entryDatabase extends RoomDatabase {
   public abstract EntryDao entryDao();

   private static entryDatabase INSTANCE;

   public static entryDatabase getEntryInstance(Context context) {
       if (INSTANCE == null) {
           INSTANCE = Room.databaseBuilder(
                   context.getApplicationContext(),
                   entryDatabase.class,
                   "entry_db").allowMainThreadQueries()
                   .build();
       }
           return INSTANCE;
       }

   }

