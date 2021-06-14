package com.example.moviecatalog.data.source

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.example.moviecatalog.data.MovieEntity
import com.example.moviecatalog.vo.Resource

interface AllDataSource {
    fun getAllMovie(): LiveData<Resource<PagedList<MovieEntity>>>

    fun getAllTvShow(): LiveData<Resource<PagedList<MovieEntity>>>

    fun getAllFavorite(): LiveData<PagedList<MovieEntity>>

    fun getCourseWithMovie(courseId: String): LiveData<Resource<MovieEntity>>

    fun getCourseWithTvShow(courseId: String): LiveData<Resource<MovieEntity>>

    fun setCourseAll(course: MovieEntity, state: Boolean)
}