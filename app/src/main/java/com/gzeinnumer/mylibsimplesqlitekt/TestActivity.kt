package com.gzeinnumer.mylibsimplesqlitekt

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.gzeinnumer.mylibsimplesqlitekt.entity.Table1
import com.gzeinnumer.mylibsimplesqlitekt.helper.GblVariabel

class TestActivity : AppCompatActivity() {
    private  val TAG = "TestActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        GblVariabel.initDb(applicationContext)

        val table1 = Table1()

//        val list: List<Table1> = table1.read()
//        Log.d(TAG, "onCreate1: " + list[0].name)
//        Log.d(TAG, "onCreate1: " + list.size)
//
//        val listQuery: List<Table1> = table1.query()
//        Log.d(TAG, "onCreate2: " + listQuery[0].name)
//        Log.d(TAG, "onCreate2: " + listQuery[0].table2_name)

//        val istrue: Boolean = table1.insert(Table1(500, "Zein", 1.3, "Decs", 1, "2020-12-12"))
//        Log.d(TAG, "onCreate3: $istrue")
//
//        val istrue2: Boolean = table1.update(Table1(500, "Zein", 1.6, "Decs", 1, "2020-11-12"))
//        Log.d(TAG, "onCreate4: $istrue2")
//
//        val count: Int = table1.count()
//        Log.d(TAG, "onCreate5: $count")

//        val istrue3 = table1.delete()
//        Log.d(TAG, "onCreate6: $istrue3")
    }
}