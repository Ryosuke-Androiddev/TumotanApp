package com.example.tumotanapp.feature.presentation.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tumotanapp.feature.domain.use_case.unite.UseCase
import com.example.tumotanapp.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val useCase: UseCase
): ViewModel() {

    //どのカードが開かれているかをここで確認する
    private val _expandedCardList = MutableStateFlow(listOf<Int>())
    val expandedCardList: StateFlow<List<Int>> get() = _expandedCardList

    private val _roomState = mutableStateOf(HomeScreenState())
    val roomState: State<HomeScreenState> = _roomState

    init {
        getAllRoom()
    }

    private fun getAllRoom(){
        useCase.getAllRoom().onEach { result ->
            when(result){

                is Result.Success -> {
                    _roomState.value = HomeScreenState(roomList = result.data ?: emptyList())
                }
                is Result.Error -> {
                    _roomState.value = HomeScreenState(error = result.message ?: "An expected Error Occurred!")
                }
                is Result.Loading -> {
                    _roomState.value = HomeScreenState(isLoading = true)
                }

            }
        }.launchIn(viewModelScope)
    }

    fun cardArrowClicked(roomId: Int){
        _expandedCardList.value = _expandedCardList.value.toMutableStateList().also { list ->
            if (list.contains(roomId)){
                list.remove(roomId)
            } else{
                list.add(roomId)
            }
        }
    }
}