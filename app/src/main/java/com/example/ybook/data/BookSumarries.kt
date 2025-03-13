package com.example.ybook.data
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bookSumarries")
data class BookSumarries (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val bookName: String,
    val bookAuthor: String,
    val content: String,
    val contentSource: String,
    val contentWordCount: Int,
    val summaryGroup: String, // Group by colum
    val summaryType: String, // Group by colum
    val summaryTime: Int,
    val bookType: String, //Key word to search or to group by
)