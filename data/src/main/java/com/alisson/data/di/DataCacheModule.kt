package com.alisson.data.di

import com.alisson.data.local.database.JobsDataBase
import com.alisson.data.local.source.JobsCacheDataSource
import com.alisson.data.local.source.JobsCacheSourceImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module

val cacheDataModule = module {
    single { JobsDataBase.createDataBase(androidContext()) }
    factory<JobsCacheDataSource> { JobsCacheSourceImpl(jobsDao = get()) }
}