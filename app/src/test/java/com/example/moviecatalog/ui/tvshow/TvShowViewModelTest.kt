package com.example.moviecatalog.ui.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.moviecatalog.data.MovieEntity
import com.example.moviecatalog.data.source.AllRepository
import com.example.moviecatalog.utils.DataDummy
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TvShowViewModelTest {

    private lateinit var viewModel: TvShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var tvShowRepository: AllRepository

    @Mock
    private lateinit var observer: Observer<List<MovieEntity>>

    @Before
    fun setUp() {
        viewModel = TvShowViewModel(tvShowRepository)
    }

    @Test
    fun getCourses() {
        val tvshowCourses = DataDummy.generateDummyMovie()
        val tvShow = MutableLiveData<List<MovieEntity>>()
        tvShow.value = tvshowCourses

        `when`(tvShowRepository.getAllTvShow()).thenReturn(tvShow)
        val courseEntities = viewModel.getTvShow().value
        verify(tvShowRepository).getAllTvShow()
        assertNotNull(courseEntities)
        assertEquals(10, courseEntities?.size)

        viewModel.getTvShow().observeForever(observer)
        Mockito.verify(observer).onChanged(tvshowCourses)
    }
}