package com.task.dogsgallery.domain.repository

import com.task.dogsgallery.data.remote.datasource.RemoteDataSource
import com.task.dogsgallery.data.repository.DogsRepository
import com.task.dogsgallery.domain.entity.DogsDomainEntities
import com.task.dogsgallery.domain.mapper.DogDomainMapper
import javax.inject.Inject

class DogsRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val mapper: DogDomainMapper
) : DogsRepository {
    override suspend fun getDogs(): DogsDomainEntities =
        mapper.apply(remoteDataSource.getDogsPhotos())
}
