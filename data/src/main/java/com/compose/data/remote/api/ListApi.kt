package com.compose.data.remote.api

import com.compose.data.remote.response.ListCommentsResponse
import com.compose.data.remote.response.ListDetailResponse
import com.compose.data.remote.response.ListResponse
import com.compose.domain.entity.ListCommentsEntity
import com.compose.domain.entity.ListDetailEntity
import retrofit2.http.GET
import retrofit2.http.Path

interface ListApi {

    @GET("posts")
    suspend fun getList(): List<ListResponse>

    @GET("posts/{id}")
    suspend fun getDetail(
        @Path("id") id: Int
    ): ListDetailResponse

    @GET("posts/{id}/comments")
    suspend fun getComments(
        @Path("id") id: Int
    ): List<ListCommentsResponse>
}