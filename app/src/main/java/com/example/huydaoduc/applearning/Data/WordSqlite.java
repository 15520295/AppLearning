package com.example.huydaoduc.applearning.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by HuyDaoDuc on 08/03/2018.
 */
//Not Use
public class WordSqlite extends SQLiteOpenHelper {

    private static final String DB_NAME = "WORD";
    private static final int DB_VERSION = 1;

    private static final String CREATE_WORD_SQL = "CREATE TABLE" + DBSQL.WORD_TABLE + "("
            + DBSQL.COLUMN_WORD_ID + " " + DBSQL.TEXT_DATA_TYPE + " " + DBSQL.PRIMARY_KEY + ", "
            + DBSQL.COLUMN_WORD_TEN + " " + DBSQL.TEXT_DATA_TYPE + " " + DBSQL.NOT_NULL + ", "
            + DBSQL.COLUMN_WORD_MOTA + " " + DBSQL.TEXT_DATA_TYPE + " " + DBSQL.NOT_NULL + ", "
            + DBSQL.COLUMN_WORD_IMAGE + " " + DBSQL.BLOB_DATA_TYPE + " " + DBSQL.NULL
            + ")";

    public WordSqlite(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
