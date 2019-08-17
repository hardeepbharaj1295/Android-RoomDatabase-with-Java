package com.daemonvision.officialtestjava.add;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.daemonvision.officialtestjava.MainActivity;
import com.daemonvision.officialtestjava.R;

public class AddNoteActivity extends AppCompatActivity {

    private AddNoteViewModelFactory modelFactory;
    private AddNoteViewModel viewModel;

    private EditText title, description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        title = findViewById(R.id.title);
        description = findViewById(R.id.description);

        modelFactory = new AddNoteViewModelFactory(this);
        viewModel = ViewModelProviders.of(this,modelFactory).get(AddNoteViewModel.class);

        viewModel.isSaved().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                Intent intent = new Intent(AddNoteActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void save(View view)
    {
        viewModel.save(title.getText().toString(), description.getText().toString());
    }

}
