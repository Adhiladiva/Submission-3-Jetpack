package com.example.moviecatalog.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.moviecatalog.data.MovieEntity
import com.example.moviecatalog.data.source.AllRepository
import com.example.moviecatalog.vo.Resource

class TvShowViewModel(private val tvShowRepository: AllRepository) : ViewModel() {

    fun getTvShow(): LiveData<Resource<PagedList<MovieEntity>>> = tvShowRepository.getAllTvShow()
}