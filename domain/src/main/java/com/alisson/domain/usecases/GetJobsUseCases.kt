package com.alisson.domain.usecases

import com.alisson.domain.entities.AndroidJob
import com.alisson.domain.repository.AndroidJobsRepository
import io.reactivex.Scheduler
import io.reactivex.Single

class GetJobsUseCases(
    private val repository: AndroidJobsRepository,
    private val scheduler: Scheduler
) {

    fun execute(forceUpdate: Boolean): Single<List<AndroidJob>> {
        return repository.getJobs(forceUpdate)
            .subscribeOn(scheduler)
    }
}