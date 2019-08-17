package com.daemonvision.officialtestjava.database;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


@Dao
public interface NoteDao {

    @Query("SELECT * FROM note ORDER BY title COLLATE NOCASE ASC")
    public DataSource.Factory<Integer, Note> getAllNotes();

    @Insert
    public void insert(Note note);

    @Update
    public void update(Note note);

    @Delete
    public void delete(Note note);

    @Query("SELECT * FROM note WHERE title= :key")
    public LiveData<Note> getNote(String key);

    @Query("SELECT * FROM note ORDER BY id DESC LIMIT 1")
    public Note getNote();

}
