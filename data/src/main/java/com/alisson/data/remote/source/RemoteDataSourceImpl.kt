package com.alisson.data.remote.source

import com.alisson.data.remote.api.ServerApi
import com.alisson.data.remote.mapper.AndroidJobMapper
import com.alisson.domain.entities.AndroidJob
import io.reactivex.Single

class RemoteDataSourceImpl(private val serverApi: ServerApi): RemoteDataSource {

    override fun getJobs(): Single<List<AndroidJob>> {
        return serverApi.fetchJobs()
            .map { AndroidJobMapper.map(it) }
    }
}