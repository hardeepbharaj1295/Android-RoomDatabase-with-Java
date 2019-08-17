package com.daemonvision.officialtestjava;

import android.content.Context;

import androidx.room.Room;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.runner.AndroidJUnit4;

import com.daemonvision.officialtestjava.database.Note;
import com.daemonvision.officialtestjava.database.NoteDao;
import com.daemonvision.officialtestjava.database.NoteDatabase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.junit.Assert;

import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import kotlin.jvm.Throws;

@RunWith(AndroidJUnit4.class)
public class NoteDatabaseTest {

    private NoteDao noteDao;
    private NoteDatabase database;

    private Executor executor = Executors.newSingleThreadExecutor();

    @Before
    public void createDb()
    {
        Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        database = Room.inMemoryDatabaseBuilder(context,NoteDatabase.class)
                .allowMainThreadQueries()
                .build();

        noteDao = database.noteDao();
    }

    @After
    @Throws(exceptionClasses = IOException.class)
    public void closeDb()
    {
        database.close();
    }

    @Test
    @Throws(exceptionClasses = IOException.class)
    public void insertAndGetNote()
    {
        final Note note = new Note(0,"title","description");
        executor.execute(new Runnable() {
            @Override
            public void run() {
                noteDao.insert(note);
            }
        });
        Note note1 =noteDao.getNote();
        Assert.assertEquals(note1.getTitle(),"title");
    }
}
