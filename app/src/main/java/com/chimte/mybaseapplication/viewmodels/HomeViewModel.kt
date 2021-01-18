package com.chimte.mybaseapplication.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.base.baselibrary.viewmodel.Auto
import com.chimte.mybaseapplication.model.Note
import com.chimte.mybaseapplication.repository.NoteRepository
import java.util.*
import kotlin.collections.ArrayList

class HomeViewModel @Auto private constructor(private val noteRepository: NoteRepository) : ViewModel() {

    //region properties

    val liveListNote by lazy {
        MutableLiveData<ArrayList<Note>>()
    }

    val liveSelectedNotes by lazy {
        MutableLiveData(Stack<Note>())
    }

    //endregion

    fun loadListNote() {
        liveListNote.value = noteRepository.getListNote()
    }

}