package com.berners.truecaller.data.datasources

import com.berners.truecaller.model.User
import com.berners.truecaller.data.Result
import kotlinx.coroutines.flow.Flow

interface UserDataSource {
    fun me(): Flow<Result<User>>
}