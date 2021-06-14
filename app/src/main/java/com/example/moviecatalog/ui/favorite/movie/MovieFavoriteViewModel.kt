package com.example.moviecatalog.ui.favorite.movie

import android.graphics.Movie
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.moviecatalog.data.MovieEntity
import com.example.moviecatalog.data.source.AllRepository
import com.example.moviecatalog.utils.DataDummy

class MovieFavoriteViewModel(private val allRepository: AllRepository) : ViewModel() {

    fun getMovieFavorite(): LiveData<PagedList<MovieEntity>> = allRepository.getAllFavorite()

    fun setFavoriteMovie(courseEntity: MovieEntity) {
        val newState = !courseEntity.favorite
        allRepository.setCourseAll(courseEntity, newState)
    }


}