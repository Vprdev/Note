package com.vietpro.note;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.vietpro.note.model.Note;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BindFragmentToPlaceholder();
    }

    private void BindFragmentToPlaceholder() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        Fragment listFragment =  NoteListFragment.newInstance();
        Fragment detailFragment = NoteDetailFragment.newInstance();
        transaction.replace(R.id.fragment_list, listFragment);
        if(findViewById(R.id.fragment_details) != null)
            transaction.replace(R.id.fragment_details, detailFragment);
        transaction.commit();
    }
}