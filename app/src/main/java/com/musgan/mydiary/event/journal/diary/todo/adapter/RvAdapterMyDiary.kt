package com.musgan.mydiary.event.journal.diary.todo.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.HorizontalScrollView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.setMargins
import androidx.recyclerview.widget.RecyclerView
import com.musgan.mydiary.event.journal.diary.todo.R

class RvAdapterMyDiary(private val dataSet: Array<String>) :
    RecyclerView.Adapter<RvAdapterMyDiary.ViewHolder>()  {
    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView
        val txt_short_desc: TextView
        val txt_date_month: TextView
        val txt_year: TextView
        val txt_day_time: TextView
        val view_tags: LinearLayout

        init {
            // Define click listener for the ViewHolder's View.
            textView = view.findViewById(R.id.txt_title)
            txt_short_desc = view.findViewById(R.id.txt_short_desc)
            txt_date_month = view.findViewById(R.id.txt_date_month)
            txt_year = view.findViewById(R.id.txt_year)
            txt_day_time = view.findViewById(R.id.txt_day_time)
            view_tags = view.findViewById(R.id.view_tags)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.row_my_diary, viewGroup, false)
        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.textView.text = dataSet[position]
        val lp: LinearLayout.LayoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT)
        lp.setMargins(10,0,0,0)

        val itemview : View = LayoutInflater.from(viewHolder.itemView.context).inflate(R.layout.component_tag, null)
        val itemview2 : View = LayoutInflater.from(viewHolder.itemView.context).inflate(R.layout.component_tag, null)
        val txt_tag: TextView = itemview.findViewById(R.id.txt_tag)
        txt_tag.layoutParams = lp

        val txt_tag2: TextView = itemview2.findViewById(R.id.txt_tag)
        txt_tag2.layoutParams = lp

        viewHolder.view_tags.addView(txt_tag)
        viewHolder.view_tags.addView(txt_tag2)
        if(position % 2 == 0) {
            viewHolder.itemView.setBackgroundColor(Color.parseColor("#e5e5e5"))
        }else viewHolder.itemView.setBackgroundColor(Color.parseColor("#ffffff"))
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size
}