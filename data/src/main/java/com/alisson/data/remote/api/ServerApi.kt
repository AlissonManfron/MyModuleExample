package com.alisson.data.remote.api

import com.alisson.data.remote.model.JobsPayload
import io.reactivex.Single
import retrofit2.http.GET

interface ServerApi {
    @GET("/AlissonManfron/test/master/data.json?token=AC74CUKWP6QRJ3G72IC6F4DBTKDBK")
    fun fetchJobs(): Single<JobsPayload>
}