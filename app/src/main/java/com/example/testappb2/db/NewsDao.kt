

package com.example.testappb2.db

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.testappb2.data.models.ListItem

@Dao
interface NewsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(items: List<ListItem>)

    @Query("SELECT * FROM news_item_table")
    fun itemsByName(): PagingSource<Int, ListItem>

    @Query("DELETE FROM news_item_table")
    suspend fun clearItems()
}
