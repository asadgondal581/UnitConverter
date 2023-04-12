package com.example.unitconverter.RoomDb


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "history")
data class History(

    @ColumnInfo(name = "unit")
    val unit: String,
    @ColumnInfo(name = "inputValues")
    val inputValues: String,
    @ColumnInfo(name = "result")
    val result: String,
){
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0
}