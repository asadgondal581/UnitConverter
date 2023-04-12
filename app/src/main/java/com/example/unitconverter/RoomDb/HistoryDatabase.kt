package com.example.unitconverter.RoomDb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [History::class], version = 1)
abstract class HistoryDatabase:RoomDatabase() {

    abstract fun historyDao(): HistoryDao

    companion object{

        @Volatile
        private var INSTANCE: HistoryDatabase? = null

        operator fun invoke(context: Context)= INSTANCE?: synchronized(this){
            INSTANCE?:buildDatabase(context).also {
                INSTANCE=it
            }
        }
        private fun buildDatabase(context: Context)=Room.databaseBuilder(
            context.applicationContext,
            HistoryDatabase::class.java,
            "app-database"
        ).build()


    }
}