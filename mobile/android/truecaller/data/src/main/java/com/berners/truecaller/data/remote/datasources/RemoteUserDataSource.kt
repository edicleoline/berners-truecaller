package com.berners.truecaller.data.remote.datasources

import com.berners.truecaller.data.datasources.UserDataSource
import com.berners.truecaller.data.remote.model.toModel
import com.berners.truecaller.model.User
import com.berners.truecaller.data.remote.services.UserService
import com.berners.truecaller.data.Result
import com.berners.truecaller.data.Result.Error
import com.berners.truecaller.data.Result.Loading
import com.berners.truecaller.data.Result.Success
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

open class RemoteUserDataSource @Inject constructor(private val service: UserService) : UserDataSource {
    override fun me(): Flow<Result<User>> {
        return flow {
            emit(Loading)
            val response = try {
                service.me()
            }
            catch (exception: IOException) {
                emit(Error(exception))
                null
            }
            if (response?.data != null) {
                emit(Success(response.data.toModel()))
            } else if (response != null) {
                emit(Error(IOException("user is null")))
            }
        }
    }
}