package com.example.moviecatalog.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.moviecatalog.data.MovieEntity

@Database(entities = [MovieEntity::class],
    version = 1,
    exportSchema = false)

abstract class AllDatabase : RoomDatabase(){

    abstract fun allDao(): AllDao

    companion object {

        @Volatile
        private var INSTANCE: AllDatabase? = null

        fun getInstance(context: Context): AllDatabase =
            INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    AllDatabase::class.java,
                    "MovieCatalog.db"
                ).build().apply {
                    INSTANCE = this
                }
            }
    }
}