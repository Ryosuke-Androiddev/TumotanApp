package com.example.tumotanapp.feature.domain.use_case.model

import com.example.tumotanapp.feature.domain.use_case.accepted.DeleteAcceptedWord
import com.example.tumotanapp.feature.domain.use_case.accepted.GetAcceptedListById
import com.example.tumotanapp.feature.domain.use_case.accepted.GetAllAcceptedList
import com.example.tumotanapp.feature.domain.use_case.accepted.InsertAcceptedWord
import com.example.tumotanapp.feature.domain.use_case.rejected.DeleteRejectedWord
import com.example.tumotanapp.feature.domain.use_case.rejected.GetAllRejectedList
import com.example.tumotanapp.feature.domain.use_case.rejected.InsertRejectedWord
import com.example.tumotanapp.feature.domain.use_case.remote.GetAllRoom
import com.example.tumotanapp.feature.domain.use_case.remote.GetRoomDetail
import com.example.tumotanapp.feature.domain.use_case.remote.GetWordListById

data class UseCase(
    val getAllRoom: GetAllRoom,
    val getRoomWithRevel: GetRoomDetail,
    val getWordList: GetWordListById,
    val getAcceptedList: GetAllAcceptedList,
    val insertAcceptedWord: InsertAcceptedWord,
    val deleteAcceptedWod: DeleteAcceptedWord,
    val getAcceptedListById: GetAcceptedListById,
    val getRejectedList: GetAllRejectedList,
    val insertRejectedWord: InsertRejectedWord,
    val deleteRejectedWord: DeleteRejectedWord
)
