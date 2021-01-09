package com.vietpro.note;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextClock;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.vietpro.note.event.NoteItemClickEvent;
import com.vietpro.note.model.Note;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class NoteDetailFragment extends Fragment {
    private TextView tViewTitle;
    private TextView tviewContent;
    private  TextView tviewDay;
    public NoteDetailFragment() {
    }
    public static Fragment newInstance() {
        return new NoteDetailFragment();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        EventBus.getDefault().register(this);
        View v = inflater.inflate(R.layout.fragment_note_detail, container, false);
        tViewTitle = v.findViewById(R.id.detail_Title);
        tviewContent = v.findViewById(R.id.detail_Content);
        tviewDay = v.findViewById(R.id.detail_Day);
        return v;
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(NoteItemClickEvent event) {
        Note note = event.getNote();
        tViewTitle.setText(note.getTitle());
        tviewContent.setText(note.getContent());
        tviewDay.setText(note.getDay());
    };
}
