package com.daemonvision.officialtestjava.show;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.daemonvision.officialtestjava.database.Note;
import com.daemonvision.officialtestjava.database.NoteDao;
import com.daemonvision.officialtestjava.database.NoteDatabase;
import com.daemonvision.officialtestjava.database.NoteRepository;

public class NoteShowViewModel extends ViewModel {

    public LiveData<PagedList<Note>> allNotes;
    private NoteRepository repository;
    private NoteDao noteDao;

    public NoteShowViewModel(Context context)
    {
        noteDao = NoteDatabase.getInstance(context).noteDao();
        repository = new NoteRepository(noteDao);
        PagedList.Config config = new PagedList.Config.Builder().setEnablePlaceholders(true)
                .setPrefetchDistance(10)
                .setPageSize(20)
                .build();
        allNotes = new LivePagedListBuilder<>(repository.getAllNotes(),config).build();
    }
}
