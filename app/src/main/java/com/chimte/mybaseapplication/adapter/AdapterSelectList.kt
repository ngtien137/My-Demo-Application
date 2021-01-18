package com.chimte.mybaseapplication.adapter

import com.base.baselibrary.adapter.SuperAdapter
import com.base.baselibrary.adapter.function.SuperSelect
import com.chimte.mybaseapplication.model.Note
import com.chimte.mybaseapplication.R

@SuperSelect(viewHandleSelectId = R.id.cvRoot, handleByLongClick = false, enableMultiSelect = true)
class AdapterSelectList : SuperAdapter<Note>(R.layout.item_note) {

}