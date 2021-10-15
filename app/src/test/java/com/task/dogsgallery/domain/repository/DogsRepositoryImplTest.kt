package com.task.dogsgallery.domain.repository

import com.task.dogsgallery.data.constants.NetworkStatus
import com.task.dogsgallery.data.remote.datasource.RemoteDataSource
import com.task.dogsgallery.data.remote.entity.DogsPhotosResponse
import com.task.dogsgallery.domain.mapper.DogDomainMapper
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test

class DogsRepositoryImplTest {
    private val remoteDataSource: RemoteDataSource = mockk(relaxed = true)
    private val mapper: DogDomainMapper = mockk(relaxed = true)

    private val repo = DogsRepositoryImpl(remoteDataSource, mapper)

    @Test
    fun `test datasource getDogsPhotos is called from repo`() {
        runBlocking {
            repo.getDogs()
            coVerify { remoteDataSource.getDogsPhotos() }
        }
    }

    @Test
    fun `test apply from DogDomainMapper is called when calling getDogsPhotos from repo `() {
        runBlocking {
            val dogsSuccess = NetworkStatus.Success(
                DogsPhotosResponse(
                    listOf(
                        "https://images.dog.ceo/breeds/dane-great/n02109047_12467.jpg"
                    ), "success"
                )
            )
            coEvery { remoteDataSource.getDogsPhotos() } returns dogsSuccess
            repo.getDogs()
            coVerify { (mapper).apply(dogsSuccess) }
        }
    }
}