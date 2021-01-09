package com.vietpro.note;

import android.app.Application;

import com.vietpro.note.dao.NoteOpenHelper;
import com.vietpro.note.model.DaoMaster;
import com.vietpro.note.model.DaoSession;

import org.greenrobot.greendao.database.Database;

public class NoteApplication extends Application {

    private DaoSession daoSession;
    static  NoteApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        // regular SQLite database
        NoteOpenHelper helper = new NoteOpenHelper(this, "note26");
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }
    public DaoSession getDaoSession() {
        return daoSession;
    }

    public static NoteApplication getInstance() {
        return instance;
    }
}
