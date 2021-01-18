package com.chimte.mybaseapplication.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import com.base.baselibrary.utils.observer
import com.base.baselibrary.viewmodel.autoViewModels
import com.base.baselibrary.views.ext.toast
import com.chimte.mybaseapplication.R
import com.chimte.mybaseapplication.adapter.AdapterSelectList
import com.chimte.mybaseapplication.databinding.FragmentHomeBinding
import com.chimte.mybaseapplication.model.Note
import com.chimte.mybaseapplication.ui.BaseMainFragment
import com.chimte.mybaseapplication.utils.AppConst
import com.chimte.mybaseapplication.viewmodels.HomeViewModel
import java.util.*

class HomeFragment : BaseMainFragment<FragmentHomeBinding>(), IHomeData {

    //region properties

    private val viewModel by autoViewModels<HomeViewModel>()

    private val adapter by lazy {
        AdapterSelectList()
    }

    //endregion

    //region lifecycle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.loadListNote()
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }

    override fun initBinding() {
        adapter.liveListSelected = viewModel.liveSelectedNotes
        binding.viewModel = viewModel
        binding.adapter = adapter
    }

    override fun initView() {
        observer(viewModel.liveListNote) {
            adapter.data = it
        }
    }

    override fun onBackPressed() {
        rootActivity.finish()
    }

    override fun onViewClick(vId: Int) {
        when (vId) {
            R.id.btnNext -> {
                val listSelected = viewModel.liveSelectedNotes.value ?: Stack()
                if (listSelected.empty()) {
                    toast("Please select some note for next screen")
                } else {
                    navigateTo(R.id.action_homeFragment_to_listFragment, Bundle().apply {
                        putSerializable(AppConst.HOME_DATA, this@HomeFragment as IHomeData)
                    })
                }
            }
        }
    }

    //endregion

    //region share data

    override fun getLiveSelectNotes(): MutableLiveData<Stack<Note>> {
        return viewModel.liveSelectedNotes
    }

    override fun onRemoveSelected() {
        toast("Removed note (show toast in home screen)")
    }

    //endregion

}