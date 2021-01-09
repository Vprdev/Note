package com.vietpro.note.dao;


import android.content.Context;
import android.util.Log;

import com.vietpro.note.NoteApplication;
import com.vietpro.note.model.DaoMaster;

import org.apache.commons.io.IOUtils;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseOpenHelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NoteOpenHelper extends DatabaseOpenHelper {
    private static final int SCHEMA_VERSION = 2;
    public NoteOpenHelper(Context context, String name){
        super(context, name, SCHEMA_VERSION);     }
    @Override
    public void onCreate(Database db) {
        super.onCreate(db);
        Log.i("greenDAO", "Creating tables for schema version " + SCHEMA_VERSION);
        DaoMaster.createAllTables(db, false);

        addBootstrapData(db);
    }

    private  void addBootstrapData(Database db){
        List<String> lines = new ArrayList<>();
        try {
            lines = IOUtils.readLines(NoteApplication.getInstance().getAssets().open("NOTE.sql"));

        }catch (IOException e){
            Log.e("NoteOpenHelper", "addBootstrapData" + e.toString());
        }
        for (String line: lines){
            db.execSQL(line);
        }

    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);
    }
}