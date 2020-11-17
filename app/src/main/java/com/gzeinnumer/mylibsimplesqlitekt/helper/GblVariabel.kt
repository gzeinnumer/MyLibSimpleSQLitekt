package com.gzeinnumer.mylibsimplesqlitekt.helper

import android.annotation.SuppressLint
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.util.Log

object GblVariabel {
    private const val TAG = "GblVariabel"
    var myDb: SQLiteDatabase? = null

    @SuppressLint("StaticFieldLeak")
    var dbHelper: DatabaseHelper? = null
    fun initDb(context: Context?) {
        try {
            dbHelper = DatabaseHelper(context!!)
            if (dbHelper!!.checkDatabase()) {
                myDb = dbHelper!!.openDataBase()
            } else {
                Log.e(TAG, "initDb:  database kosong")
            }
        } catch (throwable: Throwable) {
            throwable.printStackTrace()
            Log.e(TAG, "initDb: " + throwable.message)
        }
    }
}