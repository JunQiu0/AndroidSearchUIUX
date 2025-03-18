package com.example.ybook.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface SummaryDao {
    @Query("SELECT * FROM book_summaries WHERE book_name LIKE :searchTerm " +
            "or content LIKE :searchTerm LIMIT 10" )
    fun findSummaries(searchTerm: String): LiveData<List<BookSummary>>

    @Insert
    fun insertAll(vararg bookSumarries: BookSummary)
}