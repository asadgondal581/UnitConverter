package com.example.unitconverter.RoomDb


import androidx.room.*


@Dao
interface HistoryDao {

    @Insert()
    suspend fun insertHistory(history: History)

    @Query("SELECT * FROM history")
    suspend fun getHistory(): List<History>

    @Update
    suspend fun updateHistory(history: History)

    @Delete
    suspend fun deleteHistory(history: History)
}