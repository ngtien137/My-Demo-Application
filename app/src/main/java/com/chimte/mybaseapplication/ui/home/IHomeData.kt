package com.chimte.mybaseapplication.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.chimte.mybaseapplication.model.Note
import java.io.Serializable
import java.util.*

interface IHomeData : Serializable {

    fun getLiveSelectNotes(): MutableLiveData<Stack<Note>>

    fun onRemoveSelected()

}