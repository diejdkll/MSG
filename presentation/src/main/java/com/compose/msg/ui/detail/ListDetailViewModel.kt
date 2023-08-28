package com.compose.msg.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.compose.domain.entity.ListCommentsEntity
import com.compose.domain.entity.ListDetailEntity
import com.compose.domain.entity.ListEntity
import com.compose.domain.usecase.GetListCommentsUseCase
import com.compose.domain.usecase.GetListDetailUseCase
import com.compose.domain.usecase.GetListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListDetailViewModel @Inject constructor(
    private val getListDetailUseCase: GetListDetailUseCase,
    private val getListCommentsUseCase: GetListCommentsUseCase
): ViewModel() {

    private val _detailList = MutableStateFlow<ListDetailEntity?>(null)
    val detailList: StateFlow<ListDetailEntity?> = _detailList

    fun getDetail(id: Int) {
        viewModelScope.launch {
            _detailList.value = getListDetailUseCase.getListDetail(id).firstOrNull()
        }
    }

    private val _commentList = MutableStateFlow<List<ListCommentsEntity?>>(emptyList())
    val commentList: StateFlow<List<ListCommentsEntity?>> = _commentList

    fun getComments(id: Int) {
        viewModelScope.launch {
            _commentList.value = getListCommentsUseCase.getListComments(id).firstOrNull() ?: emptyList()
        }
    }
}