package com.task.dogsgallery.data.remote.service

import com.task.dogsgallery.data.remote.entity.DogsPhotosResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("breeds/image/random/50")
    suspend fun getDogsPhotos(): Response<DogsPhotosResponse>
}