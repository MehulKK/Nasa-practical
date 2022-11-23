package com.practical.ui.activity

import androidx.activity.viewModels
import com.practical.R
import com.practical.base.BaseAppCompatActivity
import com.practical.databinding.ActivityDetailBinding
import com.practical.model.response.NasaResponse
import com.practical.ui.activity.HomeActivity.Companion.BUNDLE_NASA_DATA
import com.practical.viewmodel.DetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : BaseAppCompatActivity<ActivityDetailBinding, DetailViewModel>() {
    override val viewModel: DetailViewModel by viewModels()

    override fun getLayoutResId(): Int = R.layout.activity_detail

    override fun initialize() {
        super.initialize()
        viewModel.data.value = intent.getSerializableExtra(BUNDLE_NASA_DATA) as NasaResponse
    }

    override fun initializeObservers(viewModel: DetailViewModel) {
        super.initializeObservers(viewModel)

    }
}
