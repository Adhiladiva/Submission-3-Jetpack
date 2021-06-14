package com.example.moviecatalog.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.moviecatalog.data.source.AllRepository
import com.example.moviecatalog.di.Injection
import com.example.moviecatalog.ui.detail.DetailMovieViewModel
import com.example.moviecatalog.ui.detail.DetailTvShowViewModel
import com.example.moviecatalog.ui.favorite.movie.MovieFavoriteViewModel
import com.example.moviecatalog.ui.favorite.tvshow.TvShowFavoriteViewModel
import com.example.moviecatalog.ui.movie.MovieViewModel
import com.example.moviecatalog.ui.tvshow.TvShowViewModel

class ViewModelFactory private constructor(private val mAllRepository: AllRepository) : ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideRepository(context)).apply {
                    instance = this
                }
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                return MovieViewModel(mAllRepository) as T
            }
            modelClass.isAssignableFrom(TvShowViewModel::class.java) -> {
                return TvShowViewModel(mAllRepository) as T
            }
            modelClass.isAssignableFrom(DetailMovieViewModel::class.java) -> {
                return DetailMovieViewModel(mAllRepository) as T
            }
            modelClass.isAssignableFrom(DetailTvShowViewModel::class.java) -> {
                return DetailTvShowViewModel(mAllRepository) as T
            }
            modelClass.isAssignableFrom(MovieFavoriteViewModel::class.java) -> {
                return MovieFavoriteViewModel(mAllRepository) as T
            }
            modelClass.isAssignableFrom(TvShowFavoriteViewModel::class.java) -> {
                return TvShowFavoriteViewModel(mAllRepository) as T
            }

            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }

    }
}