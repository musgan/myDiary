package com.musgan.mydiary.event.journal.diary.todo.nav_bottom

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.musgan.mydiary.event.journal.diary.todo.R
import com.musgan.mydiary.event.journal.diary.todo.adapter.RvAdapterMyDiary


class MyDiaryFragment : Fragment() {

    enum class LayoutManagerType {
        GRID_LAYOUT_MANAGER, LINEAR_LAYOUT_MANAGER
    }

    var rv_my_diary : RecyclerView?= null
    var mLayoutManager: RecyclerView.LayoutManager ?= null
    lateinit var mCurrentLayoutManagerType:LayoutManagerType
    lateinit var madapter: RvAdapterMyDiary
    lateinit var dataset: Array<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_diary, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_my_diary = activity?.findViewById(R.id.rv_my_diary)
        initDataset()
        madapter = RvAdapterMyDiary(dataset)
       mLayoutManager = LinearLayoutManager(activity)
        setRecyclerViewLayoutManager()
        rv_my_diary?.adapter = madapter
        val dividerItemDecoration:DividerItemDecoration = DividerItemDecoration(activity, DividerItemDecoration.VERTICAL)
        rv_my_diary?.addItemDecoration(dividerItemDecoration)
    }

    private fun setRecyclerViewLayoutManager() {
        var scrollPosition: Int = 0;
        if(rv_my_diary?.layoutManager !== null)
            scrollPosition = (rv_my_diary?.layoutManager as LinearLayoutManager).findFirstCompletelyVisibleItemPosition()

        mLayoutManager = LinearLayoutManager(activity)
        mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER

        rv_my_diary?.setLayoutManager(mLayoutManager)
        rv_my_diary?.scrollToPosition(scrollPosition)
    }
    fun initDataset() {
        dataset = arrayOf("apple", "banana", "cherry")
        println("dataset "+dataset.size)
        for (s in dataset){
            println(s)
        }
    }
}