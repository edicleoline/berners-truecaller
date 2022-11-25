package com.berners.truecaller.data.remote.interceptors

import com.berners.truecaller.data.remote.model.ResponseError
import com.google.gson.Gson
import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.Interceptor.Chain
import java.io.IOException

class HandlingExceptionInterceptor : Interceptor {
    override fun intercept(chain: Chain): Response {
        val response = chain.proceed(chain.request())
        val code = response.code()
        if (code in 400..500) {
            val body = response.body()?.string()
            if(body != null) {
                val gson = Gson()
                val responseError = gson.fromJson(body, ResponseError::class.java)
                throw IOException(responseError.error.message)
            }

            throw IOException("Unknown error")
        }

        return response
    }
}