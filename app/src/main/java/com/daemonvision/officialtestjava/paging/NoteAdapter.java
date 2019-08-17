package com.daemonvision.officialtestjava.paging;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;

import com.daemonvision.officialtestjava.R;
import com.daemonvision.officialtestjava.database.Note;

public class NoteAdapter extends PagedListAdapter<Note, NoteViewHolder> {

    public NoteAdapter()
    {
        super(DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        holder.bindTo(getItem(position));
    }

    public static final DiffUtil.ItemCallback<Note> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<Note>() {
                @Override
                public boolean areItemsTheSame(
                        @NonNull Note oldNote, @NonNull Note newNote) {
                    // Note properties may have changed if reloaded from the DB, but ID is fixed
                    return oldNote.getId() == newNote.getId();
                }
                @Override
                public boolean areContentsTheSame(
                        @NonNull Note oldNote, @NonNull Note newNote) {
                    // NOTE: if you use equals, your object must properly override Object#equals()
                    // Incorrectly returning false here will result in too many animations.
                    return oldNote == newNote;
                }
            };
}
