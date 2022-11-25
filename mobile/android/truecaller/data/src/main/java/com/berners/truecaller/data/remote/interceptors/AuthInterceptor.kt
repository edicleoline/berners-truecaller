package com.berners.truecaller.data.remote.interceptors

import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.Interceptor.Chain

class AuthInterceptor() : Interceptor {
    override fun intercept(chain: Chain): Response {
        val requestBuilder = chain.request().newBuilder()

        requestBuilder.addHeader("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOi8vMTI3LjAuMC4xOjgwMDAvYXBpL2FjY291bnQvbG9naW4iLCJpYXQiOjE2NTEwODU5ODksImV4cCI6MTY4MjYyMTk4OSwibmJmIjoxNjUxMDg1OTg5LCJqdGkiOiJaUVFYbU52Vk1wYXFRaUFFIiwic3ViIjoiMTcyMjAwMTY5MDA0MSIsInBydiI6ImY2NzYzOGEzMjZlMGE1OGU5MzY3NDZhZWZkM2RlNWM1MjAzYWMyOTEifQ.ti5tzyQnJO0CtDYVylRsqXtaQT_tA5MgOaKJPlLMB2k")

        return chain.proceed(requestBuilder.build())
    }
}