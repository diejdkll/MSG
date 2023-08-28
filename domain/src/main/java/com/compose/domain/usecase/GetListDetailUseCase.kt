package com.compose.domain.usecase

import com.compose.domain.repository.ListRepository
import javax.inject.Inject

class GetListDetailUseCase @Inject constructor(
    private val listRepository: ListRepository
) {
    fun getListDetail(id: Int) = listRepository.getListDetail(id)
}