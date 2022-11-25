package com.berners.truecaller.data.datasources

import com.berners.truecaller.model.Entity
import com.berners.truecaller.data.Result
import kotlinx.coroutines.flow.Flow

interface EntityDataSource {
    fun getEntityByIdStream(id: Long): Flow<Result<Entity>>

//    fun getPhoneByE164FormatStream(e164Format: String): Flow<Result<Phone>>
//
//    fun getPhonesByIdsStream(ids: List<Long>): Flow<Result<List<Phone>>>
//
//    fun getPhonesByE164FormatsStream(e164Formats: List<String>): Flow<Result<List<Phone>>>
//
//    suspend fun getPhoneById(id: Long): Result<Phone>
//
//    suspend fun getPhoneByE164Format(e164Format: String): Result<Phone>
//
//    suspend fun getPhonesByIds(ids: List<Long>): Result<List<Phone>>
//
//    suspend fun getPhonesByE164Formats(e164Formats: List<String>): Result<List<Phone>>

    suspend fun save(entity: Entity): Entity
}