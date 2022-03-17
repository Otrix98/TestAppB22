
package com.example.testappb2.paging

import com.example.testappb2.data.models.ListItem
import com.google.gson.annotations.SerializedName

data class SearchResponse(
    @SerializedName("totalResults") val total: Int = 0,
    @SerializedName("articles") val items: List<ListItem> = emptyList(),
)
