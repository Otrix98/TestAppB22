
package com.example.testappb2.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = NewsDatabase.NEWS_REMOTE_TABLE)
data class RemoteKeys(
    @PrimaryKey
    val itemId: String,
    val prevKey: Int?,
    val nextKey: Int?
)
