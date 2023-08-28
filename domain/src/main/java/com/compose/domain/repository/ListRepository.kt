package com.compose.domain.repository

import com.compose.domain.entity.ListCommentsEntity
import com.compose.domain.entity.ListDetailEntity
import com.compose.domain.entity.ListEntity
import kotlinx.coroutines.flow.Flow

interface ListRepository {

    fun getList(): Flow<List<ListEntity>>

    fun getListDetail(
        id: Int
    ): Flow<ListDetailEntity>

    fun getListComments(
        id: Int
    ): Flow<List<ListCommentsEntity>>
}