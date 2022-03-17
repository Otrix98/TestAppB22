
package com.example.testappb2.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.testappb2.data.models.ListItem


@Database(
    entities = [ListItem::class, RemoteKeys::class],
    version = 1,
    exportSchema = false
)
abstract class NewsDatabase : RoomDatabase() {

    abstract fun newsDao(): NewsDao
    abstract fun remoteKeysDao(): RemoteKeysDao

    companion object Constants {
        const val DB_NAME = "newsDatabase"
        const val NEWS_TABLE = "news_item_table"
        const val NEWS_REMOTE_TABLE = "news_remote_keys_table"
    }
}
