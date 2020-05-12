package com.example.dictionary

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBOpenHelper(context: Context) : SQLiteOpenHelper(context, "dictionary.db", null, 1){
    private val CREATE_TABLE_SQL = "create table dict(_id integer primary key autoincrement, word, detail)"
    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL(CREATE_TABLE_SQL)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        println("-----Version update----$oldVersion---->$newVersion")
    }
}