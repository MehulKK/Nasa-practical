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
class DetailViewModel @ViewModelInject constructor(
    private val userRepository: HomeRepository
) : BaseViewModel() {

    val data = MutableLiveData<NasaResponse>()

}
