package com.example.moviecatalog.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.moviecatalog.data.MovieEntity
import com.example.moviecatalog.data.source.AllRepository
import com.example.moviecatalog.vo.Resource

class MovieViewModel(private val allRepository: AllRepository) : ViewModel() {

    fun getMovie(): LiveData<Resource<PagedList<MovieEntity>>> = allRepository.getAllMovie()
}