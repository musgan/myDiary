package com.musgan.mydiary.event.journal.diary.todo

import android.app.ActionBar
import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import com.musgan.mydiary.event.journal.diary.todo.nav_bottom.CalendarFragment
import com.musgan.mydiary.event.journal.diary.todo.nav_bottom.MyDiaryFragment
import com.musgan.mydiary.event.journal.diary.todo.nav_bottom.ToDoFragment

class MainActivity : AppCompatActivity() {

    lateinit var navBottom: BottomNavigationView
    lateinit var viewpager: ViewPager2
    lateinit var ctx: Activity
    var actionBar: androidx.appcompat.app.ActionBar? = null
    var currentNavBottom : Int = 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        actionBar = supportActionBar
        ctx = this
        navBottom = findViewById(R.id.navBottom) as BottomNavigationView
        viewpager = findViewById(R.id.viewpager)

        val pagerAdapter = ScreenSlidePagerAdapter(this)
        viewpager.adapter = pagerAdapter

        viewpager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                when(position){
                    0 -> {
                        navBottom.selectedItemId = R.id.nav_my_diary;
                    }
                    1 -> {
                        navBottom.selectedItemId = R.id.nav_calendar;
                    }
                    2 -> {
                        navBottom.selectedItemId = R.id.nav_todo;
                    }
                }
                super.onPageSelected(position)
            }
        })

        navBottom.setOnItemSelectedListener {
            when(it.itemId){
                R.id.nav_my_diary -> {
                    viewpager.setCurrentItem(0,true);
                    true
                }
                R.id.nav_calendar -> {
                    viewpager.setCurrentItem(1,true);
                    true
                }
                R.id.nav_todo -> {
                    viewpager.setCurrentItem(2,true);
                    true;
                }
                else -> {
                    false
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_bar, menu)
        return super.onCreateOptionsMenu(menu)
    }

    private fun openFormAdd() {

    }

    private fun search() {

    }

    /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private inner class ScreenSlidePagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        override fun getItemCount(): Int = 3
        override fun createFragment(position: Int): Fragment {
            return when(position){
                0 -> {
                    MyDiaryFragment()
                }
                1 -> {
                    CalendarFragment()
                }
                2 -> {
                    ToDoFragment()
                }
                else -> {
                    MyDiaryFragment()
                }
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.menu_add -> {
                openFormAdd()
                true
            }
            R.id.menu_search -> {
                search()
                true
            }
            else -> {
                false
            }
        }
        return super.onOptionsItemSelected(item)
    }
}