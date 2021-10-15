package com.task.dogsgallery.domain.mapper

import com.task.dogsgallery.data.constants.MockedConstants.DOG_NAME
import com.task.dogsgallery.data.constants.MockedConstants.Long_DESCRIPTION
import com.task.dogsgallery.data.constants.MockedConstants.SHORT_DESCRIPTION
import com.task.dogsgallery.data.constants.NetworkConstants.GENERAL_ERROR
import com.task.dogsgallery.data.constants.NetworkStatus
import com.task.dogsgallery.data.remote.entity.DogsPhotosResponse
import com.task.dogsgallery.domain.entity.DogsDomainEntities

class DogDomainMapper {

    fun apply(dogsResponse: NetworkStatus<DogsPhotosResponse>?): DogsDomainEntities =

        dogsResponse?.data?.let { it ->
            DogsDomainEntities.DogsDomain(it.dogsPhotos?.mapIndexed { index, dogImageUrl ->
                getDogDomainItem(index, dogImageUrl)
            } ?: emptyList())
        } ?: run {
            DogsDomainEntities.Failure(dogsResponse?.errorMessage ?: GENERAL_ERROR)
        }


    private fun getDogDomainItem(
        index: Int,
        dogImageUrl: String
    ): DogsDomainEntities.DogsDomainItem =
        DogsDomainEntities.DogsDomainItem(
            name = "$DOG_NAME ${index + 1}",
            imageUrl = dogImageUrl,
            shortDescription = SHORT_DESCRIPTION,
            description = Long_DESCRIPTION,
        )
}


