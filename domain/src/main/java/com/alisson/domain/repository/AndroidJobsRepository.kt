package com.alisson.domain.repository

import com.alisson.domain.entities.AndroidJob
import io.reactivex.Single

interface AndroidJobsRepository {
    fun getJobs(forceUpdate: Boolean): Single<List<AndroidJob>>
}