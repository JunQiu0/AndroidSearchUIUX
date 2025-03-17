package com.example.ybook.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface SummaryDao {
    @Query("SELECT * FROM book_sumarries WHERE book_name LIKE :searchTerm " +
            "or content LIKE :searchTerm" )
    fun findSummaries(searchTerm: String): List<BookSumarries>

    @Insert
    fun insertAll(vararg bookSumarries: BookSumarries)
}