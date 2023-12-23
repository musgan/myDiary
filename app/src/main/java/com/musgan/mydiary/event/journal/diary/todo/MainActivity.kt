package com.musgan.mydiary.event.journal.diary.todo

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import com.musgan.mydiary.event.journal.diary.todo.nav_bottom.CalendarFragment
import com.musgan.mydiary.event.journal.diary.todo.nav_bottom.MyDiaryFragment
import com.musgan.mydiary.event.journal.diary.todo.nav_bottom.ToDoFragment

class MainActivity : AppCompatActivity() {

    lateinit var navBottom: BottomNavigationView
    lateinit var ctx: Activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ctx = this
        navBottom = findViewById(R.id.navBottom) as BottomNavigationView
        navBottom.setOnItemSelectedListener {
            when(it.itemId){
                R.id.nav_my_diary -> {
                    loadFragmentMyDiary()
                    true
                }
                R.id.nav_calendar -> {
                    loadFragmentCalendar()
                    true
                }
                R.id.nav_todo -> {
                    loadFragmentTodo()
                    true;
                }
                else -> {
                    false
                }
            }
        }
        loadFragmentMyDiary()
    }
    private fun setFragment(f: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.frameMain, f)
            .commit()
    }
    private fun loadFragmentMyDiary() {
        ctx.setTitle(R.string.nav_my_diary)
        setFragment(MyDiaryFragment())
    }
    private fun loadFragmentCalendar() {
        ctx.setTitle(R.string.nav_calendar)
        setFragment(CalendarFragment())
    }
    private fun loadFragmentTodo() {
        ctx.setTitle(R.string.nav_todo)
        setFragment(ToDoFragment())
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_bar, menu)
        return super.onCreateOptionsMenu(menu)
    }
}