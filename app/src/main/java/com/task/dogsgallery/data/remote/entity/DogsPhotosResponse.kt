package com.task.dogsgallery.data.remote.entity

import com.google.gson.annotations.SerializedName

data class DogsPhotosResponse(
    @SerializedName("message") val dogsPhotos: List<String>?,
    @SerializedName("status") val status: String?
)
