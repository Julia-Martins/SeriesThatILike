package com.example.seriesthatilike.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class database extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "list_series.db";
    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_SERIES = "list_series";
    public static final String COLUMN_ID = "id_series";
    public static final String COLUMN_seriesName = "series_name";
    public static final String COLUMN_uriSeries = "img_series";
    public static final String COLUMN_uriPlatform = "img_platform";
    public static final String COLUMN_seriesTitleDescription = "series_title_description";
    public static final String COLUMN_seriesDescription = "series_description";
    public static final String COLUMN_seriesDate = "series_date";
    public static final String COLUMN_intEpiNum = "int_episodes_num";
    public static final String COLUMN_intSeasonNum = "int_season_num";
    private static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE_SERIES + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_seriesName + " TEXT, " +
                    COLUMN_uriSeries + " TEXT, " +
                    COLUMN_uriPlatform + " TEXT, " +
                    COLUMN_seriesTitleDescription + " TEXT, " +
                    COLUMN_seriesDescription + " TEXT, " +
                    COLUMN_seriesDate + " DATE, " +
                    COLUMN_intEpiNum + " INTEGER, " +
                    COLUMN_intSeasonNum + " INTEGER " + " );";
    public database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SERIES);
        onCreate(db);
    }
}
