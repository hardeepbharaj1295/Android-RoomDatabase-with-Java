package com.daemonvision.officialtestjava.add;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.daemonvision.officialtestjava.database.Note;
import com.daemonvision.officialtestjava.database.NoteDao;
import com.daemonvision.officialtestjava.database.NoteDatabase;
import com.daemonvision.officialtestjava.database.NoteRepository;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AddNoteViewModel extends ViewModel {

    Context context;
    private Executor executor = Executors.newSingleThreadExecutor();

    private MutableLiveData<Boolean> mNoteSaved = new MutableLiveData<>();
    private NoteRepository repository;

    public AddNoteViewModel(Context context)
    {
        this.context = context;
        NoteDao noteDao = NoteDatabase.getInstance(context).noteDao();
        repository = new NoteRepository(noteDao);
    }

    private void insert(final Note note)
    {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                repository.insert(note);
            }
        });
    }

    public LiveData<Boolean> isSaved()
    {
        return this.mNoteSaved;
    }

    public void save(String title, String description)
    {
        insert(new Note(0, title,description));
        this.mNoteSaved.setValue(true);
    }

}
