package com.example.moviecatalog.ui.favorite.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.moviecatalog.data.MovieEntity
import com.example.moviecatalog.data.source.AllRepository
import com.example.moviecatalog.utils.DataDummy

class TvShowFavoriteViewModel(private val allRepository: AllRepository) : ViewModel() {

    fun getTvShowFavorite(): LiveData<PagedList<MovieEntity>> = allRepository.getAllFavorite()

    fun setFavoriteTvShow(courseEntity: MovieEntity) {
        val newState = !courseEntity.favorite
        allRepository.setCourseAll(courseEntity, newState)
    }
}