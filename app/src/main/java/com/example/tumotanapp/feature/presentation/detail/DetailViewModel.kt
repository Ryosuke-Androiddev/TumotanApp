package com.example.tumotanapp.feature.presentation.detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tumotanapp.feature.domain.use_case.GetRoomDetail
import com.example.tumotanapp.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getRoomWithLevel: GetRoomDetail,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _detailState = mutableStateOf(DetailState())
    val detailState: State<DetailState> = _detailState

    //USE CASE を使って，DtoからWordの情報を取得する必要がある

    init {

        //key を与えないと例外が発生する Jsonのキーを取得しなければいけないので get<String>("キーの名前") にする必要がある
        savedStateHandle.get<String>("roomId")?.let { roomId ->
            getRoomByLevelId(roomId.toInt())
        }

        //getRoomByLevelId(500)
    }

    private fun getRoomByLevelId(roomId: Int){
        getRoomWithLevel(roomId).onEach { result ->
            when(result){
                is Result.Success -> {
                    _detailState.value = result.data?.let { DetailState(room = result.data) } ?: DetailState(
                        room = emptyList())
                }
                is Result.Loading -> {
                    _detailState.value = DetailState(isLoading = true)
                }
                is Result.Error -> {
                    _detailState.value = DetailState(error = result.message ?: "An Unexpected Error occurred")
                }
            }
        }.launchIn(viewModelScope)
    }

}