package com.musgan.mydiary.event.journal.diary.todo.nav_bottom

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.musgan.mydiary.event.journal.diary.todo.R
import com.musgan.mydiary.event.journal.diary.todo.adapter.RvAdapterMyDiary
import com.musgan.mydiary.event.journal.diary.todo.model.MyDiary
import com.musgan.mydiary.event.journal.diary.todo.model.TagDiary


class CalendarFragment  : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calendar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setFragment(MyDiaryFragment());
    }
    private fun setFragment(f: Fragment){
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.frame_diary, f)
            ?.commit()
    }


}