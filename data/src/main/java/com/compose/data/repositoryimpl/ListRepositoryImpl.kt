package com.compose.data.repositoryimpl

import com.compose.data.remote.api.ListApi
import com.compose.data.remote.mapper.ListMapper.toEntity
import com.compose.data.remote.mapper.ListMapper.toEntityList
import com.compose.data.remote.mapper.ListMapper.toEntityListComments
import com.compose.domain.entity.ListCommentsEntity
import com.compose.domain.entity.ListDetailEntity
import com.compose.domain.entity.ListEntity
import com.compose.domain.repository.ListRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

class ListRepositoryImpl @Inject constructor(
    private val listApi: ListApi,
) : ListRepository {
    override fun getList(): Flow<List<ListEntity>> {
        return flow {
            try {
                val response = listApi.getList()
                if (response.isNotEmpty()) {
                    emit(response.toEntityList())
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    override fun getListDetail(id: Int): Flow<ListDetailEntity> {
        return flow {
            try {
                val response = listApi.getDetail(id)
                emit(response.toEntity())
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    override fun getListComments(id: Int): Flow<List<ListCommentsEntity>> {
        return flow {
            try {
                val response = listApi.getComments(id)
                if (response.isNotEmpty()) {
                    emit(response.toEntityListComments())
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}