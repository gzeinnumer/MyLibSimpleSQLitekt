package com.gzeinnumer.mylibsimplesqlitekt.entity

import com.gzeinnumer.esc.SQLiteLIB
import com.gzeinnumer.esc.struck.JoinColumn
import com.gzeinnumer.esc.struck.SQLiteTable
import com.gzeinnumer.esc.typeData.*
import com.gzeinnumer.mylibsimplesqlitekt.helper.GblVariabel

@SQLiteTable(tableName = "table1")
class Table1() : SQLiteLIB<Table1>() {
    @PrimaryKeyTypeData
    var id = 0

    @VarcharTypeData
    var name: String? = null

    @DecimalTypeData
    var rating = 0.0

    @TextTypeData
    var desc: String? = null

    @IntegerTypeData
    var flag_active = 0

    @TimeStampTypeData
    var created_at: String? = null

    //    @JoinColumn(withTable = "table2", columnName = "name")
    @JoinColumn(withTable = "table2", columnName = "name", alias = "table2_name")
    var table2_name: String? = null

    //INSERT INTO table1 (name, rating, desc, flag_active, created_at) VALUES ('Zein', '10.0.', 'Android Programmer', '1', '12-12-2020');
    fun insert(): Boolean {
        val data = Table1()
        data.name = "Zein"
        data.rating = 10.0
        data.desc = "Android Programmer"
        data.flag_active = 1
        data.created_at = "12-12-2020"
        return insertData(Table1::class.java, GblVariabel.myDb, data)
    }

    //UPDATE table1 SET name='Name Update', desc='Desc Update', flag_active='' WHERE id='1';
    fun update(): Boolean {
        //set your value to update
        val data = Table1()
        data.name = "Name Update"
        data.desc = "Desc Update"
        data.flag_active = 0
        val condition = "WHERE id='1'" //for single condition
        //String condition = "WHERE id='1' AND flag_Active='1'";      //for multi condition
        val fieldToUpdate = arrayOf(
            "name",
            "desc",
            "flag_active"
        ) // put all field that you want to update
        return updatedData(
            Table1::class.java,
            GblVariabel.myDb,
            data,
            condition,
            fieldToUpdate
        ) // return true/false
    }

    //DELETE FROM table1 WHERE id='1';
    fun delete(): Boolean {
        val condition = "WHERE id='1'" //for single condition
        //String condition = "WHERE id='1' AND flag_Active='1'";    //for multi condition
        //String condition = "1";                               //to delete all data
        return deleteData(Table1::class.java, GblVariabel.myDb, condition)
    }

    //type 1 SELECT COUNT(*) FROM table1;
    fun count(): Int {
        return countData(Table1::class.java, GblVariabel.myDb)
    }

    //type 2 SELECT COUNT(*) FROM table1 WHERE flag_Active='1';
    fun count2(): Int {
        val condition = "WHERE flag_active='1'" //for single condition
        //String condition = "WHERE id='1' AND flag_Active='1'";    //for multi condition
        return countData(Table1::class.java, GblVariabel.myDb, condition)
    }

    //type 3 Your Custom Query
    // SELECT COUNT(id) FROM table1;
    fun queryCount(): Int {
        val query = "SELECT COUNT(id) FROM table1;"
        return queryCount(Table1::class.java, GblVariabel.myDb, query)
    }

    //type 1 SElECT * FROM table1;
    fun read(): List<Table1> {
        return readData(Table1::class.java, GblVariabel.myDb)
    }

    //type 2 SELECT * FROM table1 WHERE flag_active='1';
    fun read2(): List<Table1> {
        val condition = "WHERE flag_active='1'" //for single condition
        //String condition = "WHERE id='1' AND flag_Active='1'";    //for multi condition
        return readData(Table1::class.java, GblVariabel.myDb, condition)
    }

    fun query(): List<Table1> {
        val query =
            "SELECT table1.*, table2.name AS table2_name FROM table1 JOIN table2 ON table2.id_table1 = table1.id;"
        return queryData(Table1::class.java, GblVariabel.myDb, query)
    }

    fun queryResultUpdate(): Boolean {
        val query = "UPDATE table1 SET flag_Active='2' WHERE id='1'"
        return queryResult(Table1::class.java, GblVariabel.myDb, query)
    }

}
