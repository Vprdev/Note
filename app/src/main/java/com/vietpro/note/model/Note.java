package com.vietpro.note.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Keep;

import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;
@Entity
public class Note {
    @Id(autoincrement = true)
    long id;
    String title;
    String content;
    String day;
    @Keep
    public Note(long id, String title, String content, String day) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.day = day;
    }


    public Note() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}
