package com.berners.truecaller.data.remote.services

import com.berners.truecaller.data.remote.model.User
import com.berners.truecaller.data.remote.model.ResponseData
import retrofit2.http.GET

interface UserService {
    @GET("v1/me")
    suspend fun me(): ResponseData<User>
}