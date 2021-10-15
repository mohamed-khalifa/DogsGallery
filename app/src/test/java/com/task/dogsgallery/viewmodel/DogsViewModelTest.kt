package com.task.dogsgallery.viewmodel

import com.task.dogsgallery.data.constants.MockedConstants.Long_DESCRIPTION
import com.task.dogsgallery.data.constants.MockedConstants.SHORT_DESCRIPTION
import com.task.dogsgallery.domain.entity.DogsDomainEntities
import com.task.dogsgallery.domain.usecase.GetDogsUseCase
import com.task.dogsgallery.presentation.viewmodel.DogsViewModel
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class DogsViewModelTest : ViewModelTest() {
    @Test
    fun `test uiDataState is notified with dogs list when calling getDogs`() {
        val getDogsUseCase: GetDogsUseCase = mockk(relaxed = true)
        val viewModel = DogsViewModel(getDogsUseCase)

        val dogsDomainList: List<DogsDomainEntities.DogsDomainItem> =
            listOf(
                DogsDomainEntities.DogsDomainItem(
                    "Pug1",
                    SHORT_DESCRIPTION,
                    "https://images.dog.ceo/breeds/dane-great/n02109047_12467.jpg",
                    Long_DESCRIPTION
                )
            )

        val expected = DogsDomainEntities.DogsDomain(
            dogsDomainList
        )
        runBlocking {
            coEvery { getDogsUseCase.invoke() } returns expected
            viewModel.getDogs()
            Assert.assertEquals(expected, viewModel.uiDataState.value)
        }
    }

}