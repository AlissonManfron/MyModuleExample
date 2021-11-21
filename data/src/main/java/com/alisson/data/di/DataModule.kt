package com.alisson.data.di

import com.alisson.data.AndroidJobsRepositoryImpl
import com.alisson.domain.repository.AndroidJobsRepository
import org.koin.dsl.module.module

val repositoryModule = module {
    factory<AndroidJobsRepository> {
        AndroidJobsRepositoryImpl(
            jobsCacheDataSource = get(),
            remoteDataSource = get()
        )
    }
}

val dataModules = listOf(remoteDataSourceModule, repositoryModule, cacheDataModule)