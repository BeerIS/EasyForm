package app.security.egat.easyform.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Phakpoom.I on 17/9/2560.
 */

public class MyManager {

    private Context context;
    private MyOpenHelper helper;
    private SQLiteDatabase sqLiteDatabase;


    public MyManager(Context context) {
        this.context = context;
        helper = new MyOpenHelper(context);
        sqLiteDatabase = helper.getWritableDatabase();

    }

    public long AddNameToSQLite (String strName, String strGender, String strProvince) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",strName);
        contentValues.put("gender",strGender);
        contentValues.put("province", strProvince);
        return sqLiteDatabase.insert("member",null,contentValues);
    }
}//Main Class
