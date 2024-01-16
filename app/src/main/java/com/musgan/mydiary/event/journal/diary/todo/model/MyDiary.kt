package com.musgan.mydiary.event.journal.diary.todo.model

import java.time.LocalDateTime
import java.util.Calendar
import java.util.Date

class MyDiary {
    var id: String = ""
    var title: String = ""
    var sortText: String = ""
    var createdAt : Calendar = Calendar.getInstance();
    lateinit var tags:List<TagDiary>
}