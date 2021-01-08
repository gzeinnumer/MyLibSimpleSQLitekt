package com.gzeinnumer.mylibsimplesqlitekt

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.gzeinnumer.mylibsimplesqlitekt.databinding.ActivityTestBinding
import com.gzeinnumer.mylibsimplesqlitekt.entity.Table1
import com.gzeinnumer.mylibsimplesqlitekt.helper.GblVariabel

class TestActivity : AppCompatActivity() {
    private  val TAG = "TestActivity"

    private lateinit var binding: ActivityTestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        GblVariabel.initDb(applicationContext)

        val table1 = Table1()

        binding.btnInsert.setOnClickListener { view ->
            val istrue = table1.insert()
            Log.d(TAG, "onCreate_1: $istrue")
        }
        binding.btnUpdate.setOnClickListener { view ->
            val istrue2 = table1.update()
            Log.d(TAG, "onCreate_2: $istrue2")
        }
        binding.btnDelete.setOnClickListener { view ->
            val istrue3 = table1.delete()
            Log.d(TAG, "onCreate_3: $istrue3")
        }
        binding.btnCount.setOnClickListener { view ->
            val count = table1.count()
            Log.d(TAG, "onCreate_4: $count")
        }
        binding.btnCount2.setOnClickListener { view ->
            val count2 = table1.count2()
            Log.d(TAG, "onCreate_5: $count2")
        }
        binding.btnCount3.setOnClickListener { view ->
            val count3 = table1.queryCount()
            Log.d(TAG, "onCreate_6: $count3")
        }
        binding.btnRead.setOnClickListener { view ->
            val read = table1.read()
            Log.d(TAG, "onCreate_7: " + read[0].name)
            Log.d(TAG, "onCreate_7: " + read.size)
        }
        binding.btnRead2.setOnClickListener { view ->
            val read2 = table1.read2()
            Log.d(TAG, "onCreate_8: " + read2[0].name)
            Log.d(TAG, "onCreate_8: " + read2.size)
        }
        binding.btnQuery.setOnClickListener { view ->
            val listQuery = table1.query()
            Log.d(TAG, "onCreate_9: " + listQuery[0].name)
            Log.d(TAG, "onCreate_9: " + listQuery[0].table2_name)
            Log.d(TAG, "onCreate_9: " + listQuery.size)
        }
        binding.btnQueryResultUpdate.setOnClickListener { view ->
            val queryUpdate = table1.queryResultUpdate()
            Log.d(TAG, "onCreate_10: $queryUpdate")
        }
    }
}