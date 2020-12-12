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

        //Active 1 by 1 one if you want to test it

//        val istrue = table1.insert()
//        Log.d(TAG, "onCreate1: $istrue")

//        val istrue2 = table1.update()
//        Log.d(TAG, "onCreate2: $istrue2")

//        val istrue3 = table1.delete()
//        Log.d(TAG, "onCreate3: $istrue3")

//        val count = table1.count()
//        Log.d(TAG, "onCreate4: $count")

//        val count2 = table1.count2()
//        Log.d(TAG, "onCreate5: $count2")

//        val read = table1.read()
//        Log.d(TAG, "onCreate6: " + read[0].name)
//        Log.d(TAG, "onCreate6: " + read.size)

//        val read2 = table1.read2()
//        Log.d(TAG, "onCreate7: " + read2[0].name)
//        Log.d(TAG, "onCreate7: " + read2.size)

//        val listQuery = table1.query()
//        Log.d(TAG, "onCreate8: " + listQuery[0].name)
//        Log.d(TAG, "onCreate8: " + listQuery[0].table2_name)
//        Log.d(TAG, "onCreate8: " + listQuery.size);

        val queryUpdate = table1.queryResultUpdate()
        Log.d(TAG, "onCreate9: $queryUpdate")
    }
}