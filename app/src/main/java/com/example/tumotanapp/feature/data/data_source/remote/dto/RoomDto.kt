package com.example.tumotanapp.feature.data.data_source.remote.dto


import com.example.tumotanapp.feature.domain.model.Word
import com.google.gson.annotations.SerializedName

data class RoomDto(
    @SerializedName("roomId")
    val roomId: Int,
    @SerializedName("roomName")
    val roomName: String,
    @SerializedName("wordLevelDto")
    val wordWithLevelDto: WordWithLevelDto
){
    fun toWordList(): List<Word>{
        val wordList: List<Word> = wordWithLevelDto.wordList.map { wordDto ->
            Word(wordDto.imageUrl,wordDto.meaning,wordDto.word,wordDto.roomLevelId)

        }

        return wordList
    }
}