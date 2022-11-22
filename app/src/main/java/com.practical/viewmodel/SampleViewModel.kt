package com.practical.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.practical.base.BaseViewModel
import com.practical.data.repository.HomeRepository
import com.practical.model.response.NasaResponse
import com.practical.utils.result.Event
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber

/**
 * ViewModel for [com.practical.ui.activity.HomeActivity]
 */
class SampleViewModel @ViewModelInject constructor(
    private val userRepository: HomeRepository
) : BaseViewModel() {

    val isFollow = MutableLiveData<Boolean>()

    private val _onNewMovieList = MutableLiveData<Event<ArrayList<NasaResponse>>>()
    val onNewMovieList: LiveData<Event<ArrayList<NasaResponse>>>
        get() = _onNewMovieList

    private val _isLoadingPage = MutableLiveData<Boolean>()
    val isLoadingPage: LiveData<Boolean>
        get() = _isLoadingPage

    private val _showShimmer = MutableLiveData<Boolean>()
    val showShimmer: LiveData<Boolean>
        get() = _showShimmer

    private var currentPage = 0

    init {
        loadMoreUsers()
    }

    fun loadMoreUsers() {
        _isLoadingPage.value = true
        currentPage += 1

        if (currentPage == 1) {
            _showShimmer.value = true
        }

        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                userRepository.loadUsers()
            }.onSuccess {
                withContext(Dispatchers.Main) {
                    _isLoadingPage.value = false
                    _onNewMovieList.value = Event(it)
                    if (currentPage == 1) {
                        _showShimmer.value = false
                    }
                }
            }.onFailure {
                Timber.e(it)
                withContext(Dispatchers.Main) {
                    _isLoadingPage.value = false
                    if (currentPage == 1) {
                        _showShimmer.value = false
                    }
                    currentPage -= 1 // Revert increased count
                }
            }
        }
    }
}
