package com.compose.domain.entity

data class ListCommentsEntity(
    val postId: Int,
    val id: Int,
    val name: String,
    val email: String,
    val body: String
)
