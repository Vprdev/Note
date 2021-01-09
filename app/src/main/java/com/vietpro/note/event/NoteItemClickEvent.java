package com.vietpro.note.event;

import com.vietpro.note.model.Note;

public class NoteItemClickEvent {
    private Note note;

    public NoteItemClickEvent(Note note) {

        this.note = note;
    }

    public Note getNote() {
        return note;
    }
}