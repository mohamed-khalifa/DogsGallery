package com.task.dogsgallery.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

sealed class DogsDomainEntities : Parcelable {
    @Parcelize
    data class DogsDomain(val dogs: List<DogsDomainItem>) : DogsDomainEntities()

    @Parcelize
    data class DogsDomainItem(
        val name: String,
        val imageUrl: String,
        val shortDescription: String,
        val description: String
    ) : Parcelable

    @Parcelize
    data class Failure(val errorText: String) : DogsDomainEntities()

    @Parcelize
    data class Loading(val inProgress: Boolean = false) : DogsDomainEntities()
}

