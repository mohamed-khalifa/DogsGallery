package com.task.dogsgallery.domain.mapper

import com.task.dogsgallery.data.constants.MockedConstants.Long_DESCRIPTION
import com.task.dogsgallery.data.constants.MockedConstants.SHORT_DESCRIPTION
import com.task.dogsgallery.data.constants.NetworkConstants.CONNECT_EXCEPTION
import com.task.dogsgallery.data.constants.NetworkStatus
import com.task.dogsgallery.data.remote.entity.DogsPhotosResponse
import com.task.dogsgallery.domain.entity.DogsDomainEntities
import org.junit.Assert
import org.junit.Test

class DogDomainMapperTest {
    @Test
    fun `test Dogs Connection failed response should return Failure`() {
        val dogsResponse: NetworkStatus<DogsPhotosResponse> = NetworkStatus.Error(CONNECT_EXCEPTION)
        val expected = DogsDomainEntities.Failure(CONNECT_EXCEPTION)
        val actual = DogDomainMapper().apply(dogsResponse)
        Assert.assertEquals(expected, actual)

    }

    @Test
    fun `test Dogs Images successful response should return dogs Images list`() {
        val dogsSuccessFullResponse: NetworkStatus<DogsPhotosResponse> = NetworkStatus.Success(
            DogsPhotosResponse(
                listOf(
                    "https://images.dog.ceo/breeds/dane-great/n02109047_12467.jpg",
                    "https://images.dog.ceo/breeds/airedale/n02096051_7516.jpg"
                ), "success"
            )
        )

        val dogsDomainList: List<DogsDomainEntities.DogsDomainItem> =
            listOf(
                DogsDomainEntities.DogsDomainItem(
                    "Dog 1",
                    "https://images.dog.ceo/breeds/dane-great/n02109047_12467.jpg",
                    SHORT_DESCRIPTION,
                    Long_DESCRIPTION
                ),
                DogsDomainEntities.DogsDomainItem(
                    "Dog 2",
                    "https://images.dog.ceo/breeds/airedale/n02096051_7516.jpg",
                    SHORT_DESCRIPTION,
                    Long_DESCRIPTION
                )
            )

        val expected = DogsDomainEntities.DogsDomain(dogsDomainList)
        val actual = DogDomainMapper().apply(dogsSuccessFullResponse)
        Assert.assertEquals(expected, actual)
    }

    @Test
    fun `test no Dogs Images response should return emptyList`() {
        val dogsNoDogsResponse: NetworkStatus<DogsPhotosResponse> = NetworkStatus.Success(
            DogsPhotosResponse(
                null, "error"
            )
        )
        val dogsDomainList: List<DogsDomainEntities.DogsDomainItem> =
            emptyList()

        val expected = DogsDomainEntities.DogsDomain(dogsDomainList)
        val actual = DogDomainMapper().apply(dogsNoDogsResponse)
        Assert.assertEquals(expected, actual)
    }

}