package com.task.dogsgallery.data.remote.datasource

import com.task.dogsgallery.data.constants.NetworkStatus
import com.task.dogsgallery.data.remote.entity.DogsPhotosResponse

interface RemoteDataSource {
    suspend fun getDogsPhotos(): NetworkStatus<DogsPhotosResponse>
}