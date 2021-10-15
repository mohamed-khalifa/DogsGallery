package com.task.dogsgallery.domain.usecase

import com.task.dogsgallery.data.repository.DogsRepository
import com.task.dogsgallery.domain.entity.DogsDomainEntities
import javax.inject.Inject

class GetDogsUseCase @Inject constructor(private val dogsRepository: DogsRepository) {
    suspend operator fun invoke(): DogsDomainEntities {
        return dogsRepository.getDogs()
    }
}