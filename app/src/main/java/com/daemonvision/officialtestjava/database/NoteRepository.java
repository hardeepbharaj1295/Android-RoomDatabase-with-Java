package com.daemonvision.officialtestjava.database;

import android.content.Context;

import androidx.paging.DataSource;

public class NoteRepository {

    private DataSource.Factory<Integer, Note> mAllNotes;
    private NoteDao noteDao;

    public NoteRepository(NoteDao noteDao)
    {
        this.noteDao = noteDao;
    }

    public void insert(Note note)
    {
        this.noteDao.insert(note);
    }

    public DataSource.Factory<Integer, Note> getAllNotes()
    {
        this.mAllNotes = noteDao.getAllNotes();
        return this.mAllNotes;
    }

}
