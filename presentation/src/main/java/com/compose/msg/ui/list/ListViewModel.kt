package com.compose.msg.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.compose.domain.entity.ListEntity
import com.compose.domain.usecase.GetListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    getListUseCase: GetListUseCase
): ViewModel() {

    val listState: StateFlow<List<ListEntity>> = getListUseCase.getList()
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

}