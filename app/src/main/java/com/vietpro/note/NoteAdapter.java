package com.vietpro.note;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vietpro.note.event.NoteItemClickEvent;
import com.vietpro.note.model.Note;

import org.greenrobot.eventbus.EventBus;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {
    private List<Note> notes;
    public NoteAdapter(List<Note> notes) {
        this.notes = notes;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_note, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Note note = notes.get(position);
        holder.mTvTile.setText(note.getTitle());
        holder.mTvDate.setText(note.getDay());
        holder.mTvContent.setText(note.getContent());
        holder.setCurrentNote(note);
    }
    @Override
    public int getItemCount() {
        return notes.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mTvTile;
        public final TextView mTvDate;
        public final TextView mTvContent;
        private Note note;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTvTile = itemView.findViewById(R.id.item_list_title);
            mTvDate = itemView.findViewById(R.id.item_list_date);
            mTvContent = itemView.findViewById(R.id.item_list_Content);
            itemView.setOnClickListener(v ->{
                EventBus.getDefault().post(new NoteItemClickEvent(note));
            });
        }
        public void setCurrentNote(Note note) {
            this.note = note;
        }
    }
}
