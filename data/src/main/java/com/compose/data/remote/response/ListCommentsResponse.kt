package com.compose.data.remote.response

import com.google.gson.annotations.SerializedName

data class ListCommentsResponse(
    @SerializedName("postId")
    val postId: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("body")
    val body: String
)
