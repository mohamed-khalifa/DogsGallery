package com.task.dogsgallery.data.repository

import com.task.dogsgallery.domain.entity.DogsDomainEntities

interface DogsRepository {
    suspend fun getDogs(): DogsDomainEntities
}