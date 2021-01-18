package com.chimte.mybaseapplication.ui.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.base.baselibrary.adapter.SuperAdapter
import com.base.baselibrary.utils.observer
import com.base.baselibrary.viewmodel.autoViewModels
import com.chimte.mybaseapplication.R
import com.chimte.mybaseapplication.adapter.INoteInListListener
import com.chimte.mybaseapplication.databinding.FragmentListBinding
import com.chimte.mybaseapplication.model.Note
import com.chimte.mybaseapplication.ui.BaseMainFragment
import com.chimte.mybaseapplication.ui.home.IHomeData
import com.chimte.mybaseapplication.utils.AppConst
import com.chimte.mybaseapplication.viewmodels.ListViewModel

class ListFragment : BaseMainFragment<FragmentListBinding>(), INoteInListListener {

    //region properties

    private val viewModel by autoViewModels<ListViewModel>()

    private val adapter by lazy {
        SuperAdapter<Note>(R.layout.item_note_in_list).apply {
            listener = this@ListFragment
        }
    }

    private lateinit var homeData: IHomeData

    //endregion

    //region lifecycle

    override fun getLayoutId(): Int {
        return R.layout.fragment_list
    }

    private fun getSharedData() {
        val data = arguments?.getSerializable(AppConst.HOME_DATA)
        if (data is IHomeData) {
            homeData = data
        }
    }

    override fun initBinding() {
        getSharedData()
        viewModel.liveSelectedNotes = homeData.getLiveSelectNotes()
        binding.viewModel = viewModel
        binding.adapter = adapter
    }

    override fun initView() {
        observer(viewModel.liveSelectedNotes) {
            adapter.data = it
        }
    }

    override fun onViewClick(vId: Int) {
        when (vId) {
            R.id.btnClose -> {
                onBackPressed()
            }
        }
    }

    //endregion

    //region list listener

    override fun onNoteClick(note: Note, itemPosition: Int) {
        viewModel.removeNote(note) {
            val listSize = viewModel.liveSelectedNotes.value?.size ?: 0
            adapter.notifyItemRemoved(itemPosition)
            adapter.notifyItemRangeChanged(itemPosition, listSize - 1)
            homeData.onRemoveSelected()
        }
    }

    //endregion

}