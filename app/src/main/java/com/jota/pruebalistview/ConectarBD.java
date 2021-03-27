package com.jota.pruebalistview;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ConectarBD extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Producto.db";

    private ConectarBD data;
    private SQLiteDatabase db;

    public ConectarBD (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TablaBD.ProductoEntry.TABLE_NAME + " ("
                + TablaBD.ProductoEntry.NOMBRE + " TEXT NOT NULL,"
                + TablaBD.ProductoEntry.VALOR + " INTEGER NOT NULL)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { }

}