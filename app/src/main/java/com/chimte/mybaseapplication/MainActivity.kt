package com.chimte.mybaseapplication

import com.base.baselibrary.activity.BaseActivity
import com.chimte.mybaseapplication.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {
    
    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

}