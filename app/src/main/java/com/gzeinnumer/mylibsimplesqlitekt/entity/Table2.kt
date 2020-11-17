package com.gzeinnumer.mylibsimplesqlitekt.entity

import com.gzeinnumer.mylibsimplesqlite.SQLiteLIB
import com.gzeinnumer.mylibsimplesqlite.struck.SQLiteTable
import com.gzeinnumer.mylibsimplesqlite.typeData.IntegerTypeData
import com.gzeinnumer.mylibsimplesqlite.typeData.PrimaryKeyTypeData
import com.gzeinnumer.mylibsimplesqlite.typeData.VarcharTypeData

@SQLiteTable(tableName = "table2")
class Table2 : SQLiteLIB<Table2> {
    @PrimaryKeyTypeData
    var id = 0

    @VarcharTypeData
    var name: String? = null

    @IntegerTypeData
    var id_table1 = 0

    constructor() {}
    constructor(id: Int, name: String?, id_table1: Int) {
        this.id = id
        this.name = name
        this.id_table1 = id_table1
    }

    fun insert(data: Table2): Boolean {
        return false
    }

    fun update(data: Table2, whereCondition: String?): Boolean {
        return false
    }

    fun delete(whereCondition: String?): Boolean {
        return false
    }

    fun count(): Int {
        return 0
    }

    fun read(): List<Table2>? {
        return null
    }
}
