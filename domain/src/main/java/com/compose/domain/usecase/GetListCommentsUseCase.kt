package com.compose.domain.usecase

import com.compose.domain.repository.ListRepository
import javax.inject.Inject

class GetListCommentsUseCase @Inject constructor(
    private val listRepository: ListRepository
) {
    fun getListComments(id: Int) = listRepository.getListComments(id)
}