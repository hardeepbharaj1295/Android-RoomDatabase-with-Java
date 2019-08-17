package com.daemonvision.officialtestjava.add;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class AddNoteViewModelFactory implements ViewModelProvider.Factory {

    private Context context;
    public AddNoteViewModelFactory(Context context)
    {
        this.context = context;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(AddNoteViewModel.class))
        {
            AddNoteViewModel viewModel = new AddNoteViewModel(context);
            return (T) viewModel;
        }
        throw new IllegalArgumentException("Unknown View Model Class");
    }
}
