package com.practical.data.repository

import com.practical.data.remote.ApiService
import com.practical.model.response.NasaResponse
import com.practical.utils.extension.response
import javax.inject.Inject
import javax.inject.Singleton

interface HomeRepository {
    /**
     * Loads [List] of [NasaResponse]
     */
    suspend fun loadNasaData(): ArrayList<NasaResponse>
}

@Singleton
class UserRepositoryImpl @Inject constructor(
    private val apiService: ApiService
): HomeRepository {
    override suspend fun loadNasaData(): ArrayList<NasaResponse> {
        return apiService.loadNasaData().response()
    }
}
