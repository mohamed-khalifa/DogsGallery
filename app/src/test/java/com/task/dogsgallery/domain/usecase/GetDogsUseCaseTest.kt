package com.task.dogsgallery.domain.usecase

import com.task.dogsgallery.data.repository.DogsRepository
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test

class GetDogsUseCaseTest {
    private val dogsRepository: DogsRepository = mockk(relaxed = true)
    private val getDogsUseCase = GetDogsUseCase(dogsRepository)

    @Test
    fun `test repository getDogs is called`() {
        runBlocking {
            getDogsUseCase.invoke()
            coVerify(exactly = 1) { dogsRepository.getDogs() }
        }
    }
}