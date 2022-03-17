package com.example.testappb2.data

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.testappb2.data.models.CategoryItem
import com.example.testappb2.networking.NewsApi
import com.example.testappb2.data.models.ListItem
import com.example.testappb2.db.NewsDatabase
import com.example.testappb2.paging.RemoteMediator
import kotlinx.coroutines.flow.Flow


import javax.inject.Inject

class Repository@Inject constructor(
    private val api: NewsApi,
    private val dataBase: NewsDatabase
) {

    val categoryList = listOf(
        CategoryItem("Общее", "general",true),
        CategoryItem("Развлечения", "entertainment"),
        CategoryItem("Бизнес", "business"),
        CategoryItem("Здоровье", "health"),
        CategoryItem("Наука", "science"),
        CategoryItem("Спорт", "sports"),
        CategoryItem("Технологии", "technology")
    )

    fun getSearchResultStream(query: String): Flow<PagingData<ListItem>> {
        val pagingSourceFactory = { dataBase.newsDao().itemsByName() }

        @OptIn(ExperimentalPagingApi::class)
        return Pager(
            config = PagingConfig(pageSize = NETWORK_PAGE_SIZE, enablePlaceholders = false),
            remoteMediator = RemoteMediator(
                query,
                api,
                dataBase
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }

    companion object {
        const val NETWORK_PAGE_SIZE = 20
    }
}