package com.example.moviecatalog.di

import android.content.Context
import com.example.moviecatalog.data.source.AllRepository
import com.example.moviecatalog.data.source.local.LocalDataSource
import com.example.moviecatalog.data.source.local.room.AllDatabase
import com.example.moviecatalog.data.source.remote.RemoteDataSource
import com.example.moviecatalog.utils.AppExecutors
import com.example.moviecatalog.utils.JsonHelper

object Injection {

    fun provideRepository(context: Context): AllRepository {

        val database = AllDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        val localDataSource = LocalDataSource.getInstance(database.allDao())
        val appExecutors = AppExecutors()

        return AllRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}