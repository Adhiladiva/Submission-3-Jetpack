package com.example.moviecatalog.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.moviecatalog.data.MovieEntity
import com.example.moviecatalog.data.source.AllRepository
import com.example.moviecatalog.utils.DataDummy
import com.example.moviecatalog.vo.Resource
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailTvShowViewModelTest {
    private lateinit var viewModel: DetailMovieViewModel
    private val dummyCourse = DataDummy.generateDummyTvShow()[0]
    private val courseId = dummyCourse.courseId

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var detailTvShowRepository: AllRepository

    @Mock
    private lateinit var courseObserver: Observer<Resource<MovieEntity>>

    @Before
    fun setUp() {
        viewModel = DetailMovieViewModel(detailTvShowRepository)
        viewModel.setSelectedCourse(courseId)
    }

    @Test
    fun `setSelectedCourse should be success`() {
        val expected = MutableLiveData<Resource<MovieEntity>>()
        expected.value = Resource.success(dummyCourse)

        `when`(detailTvShowRepository.getCourseWithTvShow(courseId)).thenReturn(expected)

        viewModel.courseModule.observeForever(courseObserver)

        Mockito.verify(courseObserver).onChanged(expected.value)

        val expectedValue = expected.value
        val actualValue = viewModel.courseModule.value

        assertEquals(expectedValue, actualValue)
    }

    @Test
    fun `setFavorite should be success trigger courseModule observer`() {
        val expected = MutableLiveData<Resource<MovieEntity>>()
        expected.value = Resource.success(dummyCourse)

        `when`(detailTvShowRepository.getCourseWithTvShow(courseId)).thenReturn(expected)

        viewModel.setFavorite()
        viewModel.courseModule.observeForever(courseObserver)

        Mockito.verify(courseObserver).onChanged(expected.value)

        val expectedValue = expected.value
        val actualValue = viewModel.courseModule.value

        assertEquals(expectedValue, actualValue)
    }
}