package com.compose.data.remote.mapper

import com.compose.data.remote.response.ListCommentsResponse
import com.compose.data.remote.response.ListDetailResponse
import com.compose.data.remote.response.ListResponse
import com.compose.domain.entity.ListCommentsEntity
import com.compose.domain.entity.ListDetailEntity
import com.compose.domain.entity.ListEntity

object ListMapper {

    fun List<ListResponse>.toEntityList(): List<ListEntity> {
        return map { response ->
            ListEntity(
                userId = response.userId,
                id = response.id,
                title = response.title,
                body = response.body
            )
        }
    }

    fun ListDetailResponse.toEntity() = ListDetailEntity(
        userId = userId,
        id = id,
        title = title,
        body = body
    )

    fun List<ListCommentsResponse>.toEntityListComments(): List<ListCommentsEntity> {
        return map { response ->
            ListCommentsEntity(
                postId = response.postId,
                id = response.id,
                name = response.name,
                email = response.email,
                body = response.body
            )
        }
    }
}