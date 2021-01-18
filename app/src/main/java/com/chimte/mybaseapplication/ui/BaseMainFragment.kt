package com.chimte.mybaseapplication.ui

import androidx.databinding.ViewDataBinding
import com.base.baselibrary.fragment.BaseNavigationFragment
import com.chimte.mybaseapplication.MainActivity

abstract class BaseMainFragment<BD : ViewDataBinding> : BaseNavigationFragment<BD, MainActivity>() {
}
