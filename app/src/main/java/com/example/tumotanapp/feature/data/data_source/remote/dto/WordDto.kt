package com.example.tumotanapp.feature.data.data_source.remote.dto


import com.example.tumotanapp.feature.domain.model.Word
import com.google.gson.annotations.SerializedName

data class WordDto(
    @SerializedName("imageUrl")
    val imageUrl: String,
    @SerializedName("meaning")
    val meaning: String,
    @SerializedName("roomLevelId")
    val roomLevelId: Int,
    @SerializedName("word")
    val word: String,
    @SerializedName("wordId")
    val wordId: Int
){
    fun toWord(): Word{
        return Word(
            imageUrl = imageUrl,
            meaning = meaning,
            word = word,
            roomLevelId = roomLevelId
        )
    }
}