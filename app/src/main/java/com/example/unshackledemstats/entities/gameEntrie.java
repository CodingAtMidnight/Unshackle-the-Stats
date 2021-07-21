package com.example.unshackledemstats.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "gameEntries")
public class gameEntrie {
    @PrimaryKey(autoGenerate = true)
    private int uid;

    @ColumnInfo(name = "CS")
    private int creepScore;

    @ColumnInfo(name = "Kills")
    private int gameKills;

    @ColumnInfo(name = "Deaths")
    private int gameDeaths;

    @ColumnInfo(name = "VS")
    private int visionScore;

    @ColumnInfo(name = "game_notes")
    private String gameNotes;

    @ColumnInfo(name = "reflection_notes")
    private String reflectionNotes;

    @ColumnInfo(name = "vods_notes")
    private String vodNotes;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getCreepScore() {
        return creepScore;
    }

    public void setCreepScore(int creepScore) {
        this.creepScore = creepScore;
    }

    public int getGameKills() {
        return gameKills;
    }

    public void setGameKills(int gameKills) {
        this.gameKills = gameKills;
    }

    public int getGameDeaths() {
        return gameDeaths;
    }

    public void setGameDeaths(int gameDeaths) {
        this.gameDeaths = gameDeaths;
    }

    public int getVisionScore() {
        return visionScore;
    }

    public void setVisionScore(int visionScore) {
        this.visionScore = visionScore;
    }

    public String getGameNotes() {
        return gameNotes;
    }

    public void setGameNotes(String gameNotes) {
        this.gameNotes = gameNotes;
    }

    public String getReflectionNotes() {
        return reflectionNotes;
    }

    public void setReflectionNotes(String reflectionNotes) {
        this.reflectionNotes = reflectionNotes;
    }

    public String getVodNotes() {
        return vodNotes;
    }

    public void setVodNotes(String vodNotes) {
        this.vodNotes = vodNotes;
    }
}
