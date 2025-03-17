package com.example.ybook.data
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "book_sumarries")
data class BookSumarries (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val book_name: String,
    val summary_author: String,
    val content: String,
    val content_source: String,
    val content_word_count: Int,
    val summary_group: String, // Group by colum
    val summary_type: String, // Group by colum
    val summary_time: Int,
    //val bookType: String, //Key word to search or to group by TDOO better to use other table
)