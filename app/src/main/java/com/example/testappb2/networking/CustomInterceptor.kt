package com.example.testappb2.networking

import okhttp3.Interceptor
import okhttp3.Response

class CustomInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()

        val modifiedRequest = originalRequest.newBuilder()
            .addHeader("Authorization", "6f1575b0d9d5452594f10f6ad665724d")
            .build()

        val request = chain.proceed(modifiedRequest)

        return request
    }
}