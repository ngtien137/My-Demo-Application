package com.chimte.mybaseapplication.repository

import com.chimte.mybaseapplication.model.Note

class NoteRepository {

    fun getListNote(): ArrayList<Note> {
        return ArrayList<Note>().apply {
            for (i in 0..99)
                add(Note(this.size, "Note ${this.size + 1}"))
        }
    }

}