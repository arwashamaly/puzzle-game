package com.example.puzzle_game_arwa_shamaly.Database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PatternDAO {
    @Insert
    void insertPattern(Pattern pattern);
    @Query("select * from Pattern")
    LiveData<List<Pattern>> getAllPattern();
}
