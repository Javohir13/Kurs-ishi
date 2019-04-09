package com.example.andridd.tour01.library;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import java.io.*;


public class DBHelper extends SQLiteOpenHelper {

    private Context context;
    public SQLiteDatabase mdatabase;
    private String mdatabaseName;

    public DBHelper(@Nullable Context context, @Nullable String name, int version) {
        super(context, name, null, version);

        this.context = context;
        mdatabaseName = name;
        File dbFile = context.getApplicationContext().getFileStreamPath(mdatabaseName);
        if (!dbFile.exists()) {
            getReadableDatabase();
            if (!is_openDatabase()) {
                return;
            }
        }
        openDatabase();
    }

    private void openDatabase() {
        String dbPath = context.getDatabasePath(mdatabaseName).getPath();
        if (mdatabase != null && mdatabase.isOpen()) {
            return;
        }
        mdatabase = SQLiteDatabase.openDatabase(dbPath, null, SQLiteDatabase.OPEN_READWRITE);
    }

    public void closeDatabase() {
        if (mdatabase != null) {
            mdatabase.close();
        }
    }

    public boolean is_openDatabase() {
        try {
            InputStream in = context.getAssets().open(mdatabaseName);
            String dbFileName = "/data/data/" + context.getPackageName() + "/databases/" + mdatabaseName;
            OutputStream ou = new FileOutputStream(dbFileName);
            byte[] temp = new byte[1024];
            int length;
            while ((length = in.read(temp)) > 0) {
                ou.write(temp, 0, length);
            }
            ou.flush();
            ou.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public DBHelper(Context context, String name) {
        this(context, name, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
