package com.compose.data.di

import com.compose.data.remote.api.ListApi
import com.compose.data.remote.mapper.ListMapper
import com.compose.data.repositoryimpl.ListRepositoryImpl
import com.compose.domain.repository.ListRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideListRepository(
        api: ListApi,
    ): ListRepository = ListRepositoryImpl(api)
}