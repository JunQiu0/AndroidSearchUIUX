package com.example.ybook.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [BookSumarries::class], version = 1)
abstract  class AppDatabase: RoomDatabase(){
    abstract  fun summaryDao(): SummaryDao
}