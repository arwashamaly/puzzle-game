package com.example.puzzle_game_arwa_shamaly.Database;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class PuzzleRepository {
    UserDAO userDAO;
    PuzzleDAO puzzleDAO;
    LevelDAO levelDAO;
    PatternDAO patternDAO;

    public PuzzleRepository(Application application) {
        PuzzleDatabase database = PuzzleDatabase.getDatabase(application);
        userDAO = database.userDAO();
        puzzleDAO = database.puzzleDAO();
        levelDAO = database.levelDAO();
        patternDAO = database.patternDAO();
    }

    //user
    void insertUser(User user) {
        PuzzleDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                userDAO.insertUser(user);
            }
        });
    }

    void updateUser(User user) {
        PuzzleDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                userDAO.updateUser(user);
            }
        });
    }

    LiveData<List<User>> getAllUser() {
        return userDAO.getAllUser();
    }

    //level
    void insertLevel(Level level) {
        PuzzleDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                levelDAO.insertLevel(level);
            }
        });
    }

    void updateLevel(Level level) {
        PuzzleDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                levelDAO.updateLevel(level);
            }
        });
    }


    LiveData<List<Level>> getAllLevel() {
        return levelDAO.getAllLevel();
    }

    //puzzle
    void insertPuzzle(Puzzle puzzle) {
        PuzzleDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                puzzleDAO.insertPuzzle(puzzle);
            }
        });
    }

    //جلب مجموعة الاسئلة الخاصة بالمرحلة
    LiveData<List<Puzzle>> getAllPuzzleByLevelID(int levelID) {
        return puzzleDAO.getAllPuzzleByLevelID(levelID);
    }

    //pattern
    void insertPattern(Pattern pattern) {
        PuzzleDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                patternDAO.insertPattern(pattern);
            }
        });
    }

    LiveData<List<Pattern>> getAllPattern() {
        return patternDAO.getAllPattern();
    }

}
