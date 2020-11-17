package com.gzeinnumer.mylibsimplesqlitekt.entity

import com.gzeinnumer.mylibsimplesqlite.SQLiteLIB
import com.gzeinnumer.mylibsimplesqlite.struck.JoinColumn
import com.gzeinnumer.mylibsimplesqlite.struck.SQLiteTable
import com.gzeinnumer.mylibsimplesqlite.typeData.*
import com.gzeinnumer.mylibsimplesqlitekt.helper.GblVariabel

@SQLiteTable(tableName = "table1")
class Table1 : SQLiteLIB<Table1> {
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

    constructor() {}
    constructor(
        id: Int,
        name: String?,
        rating: Double,
        desc: String?,
        flag_active: Int,
        created_at: String?
    ) {
        this.id = id
        this.name = name
        this.rating = rating
        this.desc = desc
        this.flag_active = flag_active
        this.created_at = created_at
    }

    fun insert(data: Table1): Boolean {
        return insertData(Table1::class.java, GblVariabel.myDb, data)
    }

    fun update(data: Table1): Boolean {
        val condition = "id='500'" //for single condition
        //String condition = "id='1' AND flag_Active='1'";    //for multi condition
        return updatedData(
            Table1::class.java,
            GblVariabel.myDb,
            data,
            condition
        ) // return true/false
    }

    fun delete(): Boolean {
        val condition = "id='500'" //for single condition
        //String condition = "id='1' AND flag_Active='1'";    //for multi condition
        return deleteData(Table1::class.java, GblVariabel.myDb, condition)
    }

    fun count(): Int {
//        String condition = "id='1'";
//        return countData(Table1.class, GblVariabel.myDb, condition);
        return countData(Table1::class.java, GblVariabel.myDb)
    }

    fun read(): List<Table1> {
//        String condition = "id='1'";
//        return readData(Table1.class, GblVariabel.myDb, condition);
        return readData(Table1::class.java, GblVariabel.myDb)
    }

    fun query(): List<Table1> {
        val query =
            "SELECT table1.*, table2.name AS table2_name FROM table1 JOIN table2 ON table2.id_table1 = table1.id;"
        return queryData(Table1::class.java, GblVariabel.myDb, query)
    }

}
