package app.security.egat.easyform.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Phakpoom.I on 17/9/2560.
 */

public class MyOpenHelper extends SQLiteOpenHelper{
    private Context context;
    public static final String databaseName = "easyForm.db";  //ฐานช้อมูลมีนามสกุล .db
    private static final int databaseVersion = 1;
    private static final String databaseNameTable = "CREATE TABLE member (" +
                "id INTEGER PRIMARY KEY, " +
                "name TEXT, " +
                "gender TEXT, " +
                "province TEXT" +
            ");";
    public MyOpenHelper(Context context) {
        super(context,databaseName,null,databaseVersion);   //กำหนดชื่อ db และ version ที่จะเชื่อมต่อ
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(databaseNameTable);  //execute SQL


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}   //Main Class
