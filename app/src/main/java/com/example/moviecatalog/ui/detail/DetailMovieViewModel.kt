package com.example.moviecatalog.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.moviecatalog.data.MovieEntity
import com.example.moviecatalog.data.source.AllRepository
import com.example.moviecatalog.vo.Resource

class DetailMovieViewModel(private val detailAllRepository: AllRepository) : ViewModel() {

    val courseId = MutableLiveData<String>()

    fun setSelectedCourse(courseId: String) {
        this.courseId.value = courseId
    }

    var courseModule: LiveData<Resource<MovieEntity>> = Transformations.switchMap(courseId) { mCourseId ->
        detailAllRepository.getCourseWithMovie(mCourseId)
    }

    fun setFavorite() {
        val moduleResource = courseModule.value
        if (moduleResource != null) {
            val courseWithMovie = moduleResource.data
            if (courseWithMovie != null) {
                val newState = !courseWithMovie.favorite
                detailAllRepository.setCourseAll(courseWithMovie, newState)
            }
        }
    }
}