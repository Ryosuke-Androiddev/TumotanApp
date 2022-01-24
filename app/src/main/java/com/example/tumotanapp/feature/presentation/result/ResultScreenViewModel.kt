package com.example.tumotanapp.feature.presentation.result

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.*
import com.example.tumotanapp.feature.domain.use_case.model.UseCase
import com.example.tumotanapp.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ResultScreenViewModel @Inject constructor(
    private val useCase: UseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _resultState = mutableStateOf(ResultScreenState())
    val resultState: State<ResultScreenState> = _resultState

    init {
        getAllAcceptedList()
        getRejectedList()

        //TODO
        savedStateHandle.get<Int>("roomLevelId")?.let { roomLevelId ->
            getAllAcceptedListById(roomLevelId)
        }
    }

    private fun getAllAcceptedList(){

        useCase.getAcceptedList().onEach { result ->
            when(result){

                is Result.Success -> {
                    _resultState.value = ResultScreenState(acceptedList = result.data ?: emptyList())
                }
                is Result.Error -> {
                    _resultState.value = ResultScreenState(error = result.message ?: "An expected Error Occurred!")
                }
                is Result.Loading -> {
                    _resultState.value = ResultScreenState(isLoading = true)
                }

            }
        }.launchIn(viewModelScope)
    }

    private fun getRejectedList(){

        useCase.getRejectedList().onEach { result ->
            when(result){

                is Result.Success -> {
                    _resultState.value = ResultScreenState(rejectedList = result.data ?: emptyList())
                }
                is Result.Error -> {
                    _resultState.value = ResultScreenState(error = result.message ?: "An expected Error Occurred!")
                }
                is Result.Loading -> {
                    _resultState.value = ResultScreenState(isLoading = true)
                }

            }
        }.launchIn(viewModelScope)
    }

    private fun getAllAcceptedListById(roomLevelId: Int){

        useCase.getAcceptedListById(roomLevelId).onEach { result ->
            when(result){

                is Result.Success -> {
                    _resultState.value = ResultScreenState(acceptedList = result.data ?: emptyList())
                }
                is Result.Error -> {
                    _resultState.value = ResultScreenState(error = result.message ?: "An expected Error Occurred!")
                }
                is Result.Loading -> {
                    _resultState.value = ResultScreenState(isLoading = true)
                }

            }
        }.launchIn(viewModelScope)
    }
}