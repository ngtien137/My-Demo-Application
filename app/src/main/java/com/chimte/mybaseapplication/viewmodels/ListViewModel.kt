package com.chimte.mybaseapplication.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.chimte.mybaseapplication.model.Note
import java.util.*

class ListViewModel : ViewModel() {

    var liveSelectedNotes = MutableLiveData(Stack<Note>())

    fun removeNote(note: Note, onRemoved: () -> Unit) {
        val list = liveSelectedNotes.value ?: Stack()
        if (list.remove(note)) {
            onRemoved.invoke()
        }
    }

}