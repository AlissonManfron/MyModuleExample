package com.alisson.data.remote.source

import com.alisson.domain.entities.AndroidJob
import io.reactivex.Single

interface RemoteDataSource {
    fun getJobs(): Single<List<AndroidJob>>
}