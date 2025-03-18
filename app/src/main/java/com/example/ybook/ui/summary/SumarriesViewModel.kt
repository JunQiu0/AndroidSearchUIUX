package com.example.ybook.ui.summary

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.ybook.data.AppDatabase
import com.example.ybook.data.BookSummary
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SumarriesViewModel(application: Application): AndroidViewModel(application) {
    private val summaryDao = AppDatabase.getInstance(application).summaryDao()
    private val db = AppDatabase.getInstance(application)
    fun searchTerm(searchTerm: String): LiveData<List<BookSummary>> {
       return summaryDao.findSummaries("%${searchTerm}%")
    }
}