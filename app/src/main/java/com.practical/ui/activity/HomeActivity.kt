package com.practical.ui.activity

import androidx.activity.viewModels
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.practical.R
import com.practical.base.BaseAppCompatActivity
import com.practical.databinding.ActivityHomeBinding
import com.practical.ui.adapter.NasaAdapter
import com.practical.utils.extension.launchActivity
import com.practical.utils.extension.observeEvent
import com.practical.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeActivity : BaseAppCompatActivity<ActivityHomeBinding, HomeViewModel>() {
    override val viewModel: HomeViewModel by viewModels()

    override fun getLayoutResId(): Int = R.layout.activity_home

    private lateinit var movieAdapter : NasaAdapter

    override fun initialize() {
        super.initialize()
        val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        layoutManager.gapStrategy = StaggeredGridLayoutManager.GAP_HANDLING_NONE
        layoutManager.gapStrategy = StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS
        binding.rvUsers.layoutManager = layoutManager
        binding.rvUsers.setHasFixedSize(true)

        movieAdapter = NasaAdapter(viewModel)
        binding.rvUsers.adapter = movieAdapter
    }

    override fun initializeObservers(viewModel: HomeViewModel) {
        super.initializeObservers(viewModel)

        binding.shimmer.startShimmer()

        viewModel.showShimmer.observe(this) {
            if (it) {
                binding.shimmer.startShimmer()
            } else {
                binding.shimmer.stopShimmer()
            }
        }

        viewModel.isLoadingPage.observe(this) {
            if (it) {
                movieAdapter.addLoader()
            } else {
                movieAdapter.removeLoader()
            }
        }

        viewModel.onNewMovieList.observeEvent(this) {
            movieAdapter.addAllItem(it)
        }

        viewModel.clickHandler.observe(this) { nasaData ->
            launchActivity<DetailActivity> {
                putExtra(BUNDLE_NASA_DATA, nasaData)
            }
        }
    }

    companion object {
        const val BUNDLE_NASA_DATA = "BUNDLE_NASA_DATA"
    }
}
