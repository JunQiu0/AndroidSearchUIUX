package com.example.ybook.data
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "book_summaries")
data class BookSummary (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "book_name") val bookName: String,
    @ColumnInfo(name = "summary_author") val summaryAuthor: String?=null,
    @ColumnInfo(name = "content") val content: String,
    @ColumnInfo(name = "content_source") val contentSource: String?=null,
    @ColumnInfo(name = "content_word_count") val contentWordCount: Int,
    @ColumnInfo(name = "summary_group") val summaryGroup: String?=null, // Group by colum
    @ColumnInfo(name = "summary_type") val summaryType: String?=null, // Group by colum
    @ColumnInfo(name = "summary_time") val summaryTime: Int?=null,
    //val bookType: String, //Key word to search or to group by TDOO better to use other table
)