package com.compose.domain.di

import com.compose.domain.repository.ListRepository
import com.compose.domain.usecase.GetListCommentsUseCase
import com.compose.domain.usecase.GetListDetailUseCase
import com.compose.domain.usecase.GetListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideGetListUseCase(
        listRepository: ListRepository
    ): GetListUseCase = GetListUseCase(listRepository)

    @Provides
    @Singleton
    fun provideGetListDetailUseCase(
        listRepository: ListRepository
    ): GetListDetailUseCase = GetListDetailUseCase(listRepository)

    @Provides
    @Singleton
    fun provideGetListCommentsUseCase(
        listRepository: ListRepository
    ): GetListCommentsUseCase = GetListCommentsUseCase(listRepository)
}