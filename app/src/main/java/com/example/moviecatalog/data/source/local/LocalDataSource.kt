package com.example.moviecatalog.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.example.moviecatalog.data.MovieEntity
import com.example.moviecatalog.data.source.local.room.AllDao

class LocalDataSource private constructor(private val mAllDao: AllDao) {

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(allDao: AllDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(allDao)
    }

    fun getAllMovie(): DataSource.Factory<Int, MovieEntity>  = mAllDao.getAllMovie()

    fun getAllTvShow(): DataSource.Factory<Int, MovieEntity> = mAllDao.getAllTvShow()

    fun getAllFavorite(): DataSource.Factory<Int, MovieEntity> = mAllDao.getAllFavorite()

    fun getCourseWithModules(courseId: String): LiveData<MovieEntity> =
        mAllDao.getCourseWithModuleById(courseId)

    fun insertAll(courses: List<MovieEntity>) = mAllDao.insertAll(courses)

    fun setAllFavorite(course: MovieEntity, newState: Boolean) {
        course.favorite = newState
        mAllDao.updateAll(course)
    }
}