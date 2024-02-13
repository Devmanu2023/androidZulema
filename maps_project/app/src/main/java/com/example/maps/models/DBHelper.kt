package com.example.maps.models

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(
    //Implementar metodos de DBHelper con alt+enter
    //Extender la clase de SQLite
    context: Context
): SQLiteOpenHelper(context, DBConstants.NOM_BD, null, DBConstants.VERSION_BD) {
    override fun onCreate(database: SQLiteDatabase?) {

        //db?.execSQL(DBConstants.TABLA)
        database?.execSQL(DBConstants.DATA)
    }

    override fun onUpgrade(database: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

        database?.execSQL("DROP TABLE IF EXISTS data")
        onCreate(database)
    }


}