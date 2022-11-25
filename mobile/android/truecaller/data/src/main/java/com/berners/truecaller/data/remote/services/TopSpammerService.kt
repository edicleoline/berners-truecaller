package com.berners.truecaller.data.remote.services

import com.berners.truecaller.data.remote.model.TopSpammer
import com.berners.truecaller.data.remote.model.ResponsePaginated
import com.berners.truecaller.model.IncomingType
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TopSpammerService {
    @GET("v1/top-spammers/{incomingType}")
    suspend fun listByIncomingType(
        @Path("incomingType") incomingType: IncomingType,
        @Query("max_results") maxResults: Int,
    ): ResponsePaginated<TopSpammer>
}