package com.gzeinnumer.mylibsimplesqlitekt.helper

import android.content.Context
import android.database.SQLException
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Environment
import android.util.Log
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStream

class DatabaseHelper(protected val context: Context) :
    SQLiteOpenHelper(
        context,
        DATABASE_NAME,
        null,
        DATABASE_VERSION
    ) {
    protected var myDataBase: SQLiteDatabase? = null
    override fun onCreate(db: SQLiteDatabase) {
        Log.d(TAG, "onCreate: ")
    }

    override fun onUpgrade(
        db: SQLiteDatabase,
        oldVersion: Int,
        newVersion: Int
    ) {
        Log.d(TAG, "onUpgrade: ")
    }

    fun checkDatabase(): Boolean {
        var statusDB = false
        var checkDB: SQLiteDatabase? = null
        val myPath =
            DB_PATH + DATABASE_NAME
        try {
            if (File(myPath).exists()) {
                try {
                    checkDB = SQLiteDatabase.openDatabase(myPath, null, 0)
                    statusDB = true
                } catch (e: Exception) {
                    statusDB = false
                }
            } else {
                statusDB = false
            }
        } catch (e: SQLException) {
            e.printStackTrace()
        }
        checkDB?.close()
        return statusDB
    }

    @Throws(IOException::class)
    fun createDatabase() {
        if (!checkDatabase()) {
            readableDatabase
            copyDatabase()
        }
    }

    @Throws(IOException::class)
    private fun copyDatabase() {
        val myInput =
            context.assets.open(DATABASE_NAME_ASSET)
        val copyPath =
            DB_PATH + DATABASE_NAME
        val outFile = context.getDatabasePath(copyPath)
        outFile.delete()
        val myOutput: OutputStream = FileOutputStream(outFile)
        val buffer = ByteArray(1204)
        while (true) {
            val length = myInput.read(buffer)
            if (length <= 0) {
                myOutput.flush()
                myOutput.close()
                myInput.close()
                return
            }
            myOutput.write(buffer, 0, length)
        }
    }

    @Throws(SQLException::class)
    fun openDataBase(): SQLiteDatabase? {
        val openPath =
            DB_PATH + DATABASE_NAME
        myDataBase = SQLiteDatabase.openDatabase(openPath, null, 0)
        return myDataBase
    }

    fun deleteDatabase(): Boolean {
        val path =
            DB_PATH + DATABASE_NAME
        val file = File(path)
        return file.delete()
    }

    companion object {
        private const val TAG = "DatabaseHelper"
        protected const val DATABASE_NAME = "MyLibSQLiteSimple.db"
        protected const val DATABASE_NAME_ASSET = "MyLibSQLiteSimple.db"
        protected var DB_PATH = ""
        protected const val DATABASE_VERSION = 4
    }

    init {
        DB_PATH = Environment.getExternalStorageDirectory().toString() + "/MyLibSQLite/"
        Log.d(TAG, "DatabaseHelper: Database exist $DB_PATH")
        val myPath =
            DB_PATH + DATABASE_NAME
        val dbFile = File(myPath)
        if (dbFile.exists()) {
            Log.d(TAG, "DatabaseHelper: Database exist")
        } else {
            if (!checkDatabase()) {
                try {
                    readableDatabase
                    copyDatabase()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }
    }
}
