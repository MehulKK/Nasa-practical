package com.practical.ui.activity

import androidx.activity.viewModels
import com.practical.R
import com.practical.base.BaseAppCompatActivity
import com.practical.databinding.ActivitySplashBinding
import com.practical.utils.extension.launchActivity
import com.practical.utils.extension.observeEvent
import com.practical.viewmodel.SplashViewModel
import com.practical.viewmodel.SplashViewModel.Destination
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : BaseAppCompatActivity<ActivitySplashBinding, SplashViewModel>() {

    override val viewModel: SplashViewModel by viewModels()

    override fun getLayoutResId(): Int = R.layout.activity_splash

    override fun initializeObservers(viewModel: SplashViewModel) {
        super.initializeObservers(viewModel)

        viewModel.goToScreen.observeEvent(this) { destination ->
            when (destination) {
                Destination.Home -> openHomeScreen()
                Destination.Login -> openLoginScreen()
                Destination.Sample -> openSampleScreen()
            }
        }
    }

    private fun openLoginScreen() {
        // TODO : Open Login screen
    }

    private fun openHomeScreen() {
        // TODO : Open Home screen
    }

    private fun openSampleScreen() {
        launchActivity<HomeActivity>()
    }
}
