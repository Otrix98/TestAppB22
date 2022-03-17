package com.example.testappb2.networking

import com.example.testappb2.paging.SearchResponse
import retrofit2.http.*

interface NewsApi {

    @GET("/v2/top-headlines")
    suspend fun searchItems(
        @Query("country") country: String,
        @Query("category") category: String,
        @Query("page") page: Int,
        @Query("pageSize") itemsPerPage: Int
    ): SearchResponse
}

