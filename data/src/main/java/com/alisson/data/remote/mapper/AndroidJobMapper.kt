package com.alisson.data.remote.mapper

import com.alisson.data.remote.model.AndroidJobPayload
import com.alisson.data.remote.model.JobsPayload
import com.alisson.domain.entities.AndroidJob

object AndroidJobMapper {

    fun map(payload: JobsPayload) = payload.jobsPayload.map { map(it) }

    private fun map(payload: AndroidJobPayload) = AndroidJob(
        title = payload.title,
        experienceTimeRequired = payload.requiredExperienceYears,
        native = payload.native,
        country = payload.country
    )
}