package com.example.testappb2.data.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.testappb2.db.NewsDatabase
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = NewsDatabase.NEWS_TABLE)
data class ListItem (
    @PrimaryKey
    val url: String,
    val title: String,
    val urlToImage: String?,
    val author: String?,
    val description: String?,
    val publishedAt: String,
    val content: String?,
    ):Parcelable