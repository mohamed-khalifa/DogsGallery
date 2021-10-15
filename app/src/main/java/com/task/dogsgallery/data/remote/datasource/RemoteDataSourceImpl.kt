package com.task.dogsgallery.data.remote.datasource

import com.task.dogsgallery.data.constants.NetworkStatus
import com.task.dogsgallery.data.remote.service.ApiService
import com.task.dogsgallery.data.util.safeApiCall
import com.task.dogsgallery.data.remote.entity.DogsPhotosResponse

class RemoteDataSourceImpl(private val apiService: ApiService) : RemoteDataSource {
    override suspend fun getDogsPhotos(): NetworkStatus<DogsPhotosResponse> {
        return safeApiCall { apiService.getDogsPhotos() }
    }
}