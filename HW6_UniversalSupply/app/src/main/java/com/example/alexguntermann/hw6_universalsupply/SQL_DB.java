package com.example.alexguntermann.hw6_universalsupply;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by alexguntermann on 4/25/18.
 */

public class SQL_DB extends SQLiteOpenHelper {


    int DB_VERSION = 1;
    String DB_NAME = "myDB.db";
    Context context;
    String tableName = "employees";

    public SQL_DB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context = context;
        DB_VERSION = version;
        DB_NAME = name;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL("CREATE TABLE "+ tableName +" ("
                    + " _id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "firstname TEXT NOT NULL, "//add all char
                    + "lastname TEXT NOT NULL, "//2
                    + "food TEXT NOT NULL, "
                    + "food2 TEXT NOT NULL, "//4
                    + "diet TEXT NOT NULL, "
                    + "age INTEGER NOT NULL,"
                    + "gender TEXT NOT NULL, "//7
                    + "color TEXT NOT NULL,"//8
                    + "salary INTEGER NOT NULL);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int olderVersion, int newVersion) {

    }

    public void deleteDataBase(){
        SQLiteDatabase delete = this.getReadableDatabase();
        delete.execSQL("delete from "+tableName);
    }
}
