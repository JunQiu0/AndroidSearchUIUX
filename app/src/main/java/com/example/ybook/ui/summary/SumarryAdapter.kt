package com.example.ybook.ui.summary

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ybook.R
import com.example.ybook.data.BookSummary

class SumarryAdapter: RecyclerView.Adapter<SumarryAdapter.ViewHolder>() {
    private var sumarries: List<BookSummary> = emptyList()

    // Create view for earch item
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.sumarry, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // contents of the view with that element
        viewHolder.content.text = sumarries[position].content
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
         val content: TextView = view.findViewById<TextView>(R.id.summaryContent)
    }

    fun setSumarries(sumarries: List<BookSummary> ) {
        this.sumarries = sumarries;
        // Change all
        notifyDataSetChanged();
    }

    override fun getItemCount(): Int = sumarries.size


}