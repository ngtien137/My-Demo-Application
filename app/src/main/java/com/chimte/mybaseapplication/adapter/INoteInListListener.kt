package com.chimte.mybaseapplication.adapter

import com.base.baselibrary.adapter.listener.ListItemListener
import com.chimte.mybaseapplication.model.Note

interface INoteInListListener : ListItemListener {
    fun onNoteClick(note: Note, itemPosition: Int)
}