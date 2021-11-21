package com.alisson.mymoduleexample

import androidx.multidex.MultiDexApplication
import com.alisson.data.di.dataModules
import com.alisson.mymoduleexample.di.presentationModule
import domainModule
import org.koin.android.ext.android.startKoin

class MyModuleApplication : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()

        startKoin(
            this@MyModuleApplication,
            domainModule + dataModules + listOf(presentationModule)
        )
    }
}