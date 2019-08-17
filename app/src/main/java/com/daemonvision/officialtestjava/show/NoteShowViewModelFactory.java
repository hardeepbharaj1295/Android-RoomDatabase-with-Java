package com.daemonvision.officialtestjava.show;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.daemonvision.officialtestjava.add.AddNoteViewModel;

public class NoteShowViewModelFactory implements ViewModelProvider.Factory {

    private Context context;
    public NoteShowViewModelFactory(Context context)
    {
        this.context = context;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(NoteShowViewModel.class))
        {
            NoteShowViewModel viewModel = new NoteShowViewModel(context);
            return (T) viewModel;
        }
        throw new IllegalArgumentException("Unknown View Model Class");
    }
}
