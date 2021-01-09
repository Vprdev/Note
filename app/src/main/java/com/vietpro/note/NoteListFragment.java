package com.vietpro.note;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.vietpro.note.model.Note;
import com.vietpro.note.model.NoteDao;

import java.util.List;

public class NoteListFragment extends Fragment{

    public static Fragment newInstance() {
        return new NoteListFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_note_list, container, false);
        RecyclerView recyclerView = v.findViewById(R.id.rclNotes);
        NoteDao noteDao = NoteApplication.getInstance().getDaoSession().getNoteDao();
        List<Note> notes = noteDao.loadAll();
        NoteAdapter noteAdapter = new NoteAdapter(notes);
        recyclerView.setAdapter(noteAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return v;
    }
}
