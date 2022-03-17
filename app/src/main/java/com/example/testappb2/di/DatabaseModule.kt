package com.example.testappb2.di

import android.app.Application
import androidx.room.Room
import com.example.testappb2.db.NewsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

@Provides
@Singleton
fun providesDatabase(application: Application): NewsDatabase {
    return Room.databaseBuilder(
        application,
        NewsDatabase::class.java,
        NewsDatabase.DB_NAME
    )
        .build()
}
}