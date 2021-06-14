package com.example.moviecatalog.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.example.moviecatalog.data.MovieEntity

@Dao
interface AllDao {

    @Query("SELECT * FROM movieEntities")
    fun getAllMovie(): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM movieEntities")
    fun getAllTvShow(): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM movieEntities where favorite = 1")
    fun getAllFavorite(): DataSource.Factory<Int, MovieEntity>

    @Transaction
    @Query("SELECT * FROM movieEntities WHERE courseId = :courseId")
    fun getCourseWithModuleById(courseId: String): LiveData<MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(courses: List<MovieEntity>)

    @Update
    fun updateAll(course: MovieEntity)
}