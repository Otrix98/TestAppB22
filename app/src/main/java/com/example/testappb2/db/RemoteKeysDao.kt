

package com.example.testappb2.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.testappb2.db.RemoteKeys

@Dao
interface RemoteKeysDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(remoteKey: List<RemoteKeys>)

    @Query("SELECT * FROM news_remote_keys_table WHERE itemId = :itemId")
    suspend fun remoteKeysRepoId(itemId: String): RemoteKeys?

    @Query("DELETE FROM news_remote_keys_table")
    suspend fun clearRemoteKeys()
}
