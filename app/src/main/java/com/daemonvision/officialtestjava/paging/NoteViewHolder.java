package com.daemonvision.officialtestjava.paging;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.daemonvision.officialtestjava.R;
import com.daemonvision.officialtestjava.database.Note;

public class NoteViewHolder extends RecyclerView.ViewHolder {

    private final TextView title;
    private final TextView description;
    private Note note;

    public NoteViewHolder(@NonNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.title);
        description = itemView.findViewById(R.id.description);
    }

    public void bindTo(Note note)
    {
        this.note = note;
        title.setText(this.note.getTitle());
        description.setText(this.note.getDescription());
    }

}
