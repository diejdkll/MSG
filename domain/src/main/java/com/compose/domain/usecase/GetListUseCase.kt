package com.compose.domain.usecase

import com.compose.domain.repository.ListRepository
import javax.inject.Inject

class GetListUseCase @Inject constructor(
    private val listRepository: ListRepository
) {
    fun getList() = listRepository.getList()
}