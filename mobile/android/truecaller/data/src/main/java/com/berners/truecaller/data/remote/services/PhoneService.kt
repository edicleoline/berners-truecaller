package com.berners.truecaller.data.remote.services

import com.berners.truecaller.data.remote.model.Phone
import com.berners.truecaller.data.remote.model.ResponseData
import retrofit2.http.GET
import retrofit2.http.Path

interface PhoneService {
    @GET("v1/phones/{id}")
    suspend fun findById(@Path("id") id: Long): ResponseData<Phone>
}