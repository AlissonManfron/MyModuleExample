package com.alisson.mymoduleexample.di

import com.alisson.mymoduleexample.feature.list.AndroidJobListViewModel
import com.alisson.mymoduleexample.feature.list.AndroidJobsAdapter
import com.alisson.mymoduleexample.feature.main.MainViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val presentationModule = module {

    factory { AndroidJobsAdapter() }

    viewModel { MainViewModel() }

    viewModel {
        AndroidJobListViewModel(
            useCase = get(),
            uiScheduler = AndroidSchedulers.mainThread()
        )
    }
}