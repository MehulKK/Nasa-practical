package com.practical.data.remote

import com.practical.model.response.NasaResponse
import retrofit2.Response
import retrofit2.http.GET

/**
 * Provides remote APIs
 */
interface ApiService {
    @GET("take-home-exercise-data/trunk/nasa-pictures.json")
    suspend fun loadUsers(): Response<ArrayList<NasaResponse>>
}
