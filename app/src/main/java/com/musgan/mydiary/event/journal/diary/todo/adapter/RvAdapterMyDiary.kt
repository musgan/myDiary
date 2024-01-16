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
import com.musgan.mydiary.event.journal.diary.todo.model.MyDiary
import java.text.SimpleDateFormat

class RvAdapterMyDiary(val dataSet: MutableList<MyDiary>) :
    RecyclerView.Adapter<RvAdapterMyDiary.ViewHolder>()  {
    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView
        val txt_short_desc: TextView
        val txt_date_month: TextView
        val txt_year: TextView
        val txt_day_time: TextView
        val view_tags: LinearLayout

        init {
            // Define click listener for the ViewHolder's View.
            title = view.findViewById(R.id.txt_title)
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
        val myDiary = dataSet.get(position)
        viewHolder.title.text = myDiary.title
        viewHolder.txt_short_desc.text = myDiary.sortText
        viewHolder.txt_date_month.text = SimpleDateFormat("dd MMMM").format(myDiary.createdAt.time)
        viewHolder.txt_year.text = SimpleDateFormat("yyyy").format(myDiary.createdAt.time)
        viewHolder.txt_day_time.text = SimpleDateFormat("EEE, h:mm a").format(myDiary.createdAt.time)
        val lp: LinearLayout.LayoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT)
        lp.setMargins(10,0,0,0)

        myDiary.tags.forEach { item ->
            val itemview: View = LayoutInflater.from(viewHolder.itemView.context)
                .inflate(R.layout.component_tag, null)
            val txt_tag: TextView = itemview.findViewById(R.id.txt_tag)
            txt_tag.layoutParams = lp
            txt_tag.text = item.name
            viewHolder.view_tags.addView(txt_tag)
        }
        if(position % 2 == 1) {
            viewHolder.itemView.setBackgroundColor(Color.parseColor("#e5e5e5"))
        }else viewHolder.itemView.setBackgroundColor(Color.parseColor("#ffffff"))
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size
}