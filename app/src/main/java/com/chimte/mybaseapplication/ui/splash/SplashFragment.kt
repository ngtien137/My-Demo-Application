package com.chimte.mybaseapplication.ui.splash

import android.graphics.drawable.Animatable
import android.graphics.drawable.AnimatedVectorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.base.baselibrary.views.ext.doInMainThread
import com.chimte.mybaseapplication.R
import com.chimte.mybaseapplication.databinding.FragmentSplashBinding
import com.chimte.mybaseapplication.ui.BaseMainFragment

class SplashFragment : BaseMainFragment<FragmentSplashBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.fragment_splash
    }

    override fun initView() {
        val drawable = binding.imgMain.drawable
        if (drawable is Animatable) {
            drawable.start()
        }
        doInMainThread({
            doAction {
                navigateTo(R.id.action_splashFragment_to_homeFragment)
            }
        }, 3000)
    }

    private fun doAction(onAction: () -> Unit) {
        onAction.invoke()
    }

}