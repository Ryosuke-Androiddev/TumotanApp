package com.example.tumotanapp.feature.presentation.study

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tumotanapp.feature.domain.use_case.GetWordListById
import com.example.tumotanapp.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class StudyViewModel @Inject constructor(
    private val getWordListById: GetWordListById,
    private val savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _wordState = mutableStateOf(WordState())
    val wordState: State<WordState> = _wordState

    //USE CASE を使って，DtoからWordの情報を取得する必要がある

    init {

        //こう処理する必要ある??
        savedStateHandle.get<String>("roomId")?.let { roomId ->
            savedStateHandle.get<String>("roomLevelId")?.let { roomLevel ->
                getRoomById(roomId.toInt(), roomLevel.toInt())
            }
        }
    }

    //ここのIdの取得方法をここで詳しく定義する
    private fun getRoomById(roomId: Int, roomLevel: Int){
        getWordListById(roomId, roomLevel).onEach { result ->
            when(result){
                is Result.Success -> {
                    _wordState.value = result.data?.let { WordState(word = it ) } ?: WordState(word = emptyList())
                }
                is Result.Loading -> {
                    _wordState.value = WordState(isLoading = true)
                }
                is Result.Error -> {
                    _wordState.value = WordState(error = result.message ?: "An Unexpected Error occurred")
                }
            }
        }.launchIn(viewModelScope)
    }
}