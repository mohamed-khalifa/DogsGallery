package com.task.dogsgallery.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.task.dogsgallery.domain.entity.DogsDomainEntities
import com.task.dogsgallery.domain.usecase.GetDogsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DogsViewModel @Inject constructor(
    private val dogsUseCase: GetDogsUseCase
) : ViewModel() {

    private val _loadingState = MutableLiveData<DogsDomainEntities.Loading>()
    val loadingState: LiveData<DogsDomainEntities.Loading> = _loadingState

    private val _uiDataState = MutableLiveData<DogsDomainEntities>()
    val uiDataState: LiveData<DogsDomainEntities> = _uiDataState

    fun getDogs() {
        viewModelScope.launch {
            _loadingState.value = DogsDomainEntities.Loading(true)
            _uiDataState.postValue(dogsUseCase.invoke())
            _loadingState.postValue(DogsDomainEntities.Loading(false))
        }
    }
}