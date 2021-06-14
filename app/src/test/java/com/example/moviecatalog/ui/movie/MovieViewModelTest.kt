package com.example.moviecatalog.ui.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import androidx.paging.PositionalDataSource
import com.example.moviecatalog.data.MovieEntity
import com.example.moviecatalog.data.source.AllRepository
import com.example.moviecatalog.utils.DataDummy
import com.example.moviecatalog.vo.Resource
import org.junit.Assert
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import java.util.concurrent.Executors

@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {

    private lateinit var viewModel: MovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var allRepository: AllRepository

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<MovieEntity>>>

    @Before
    fun setUp() {
        viewModel = MovieViewModel(allRepository)
    }

    @Test
    fun `getCourses should be success`() {
        val movieCourses = PagedTestDataSources.snapshot(DataDummy.generateDummyMovie())
        val movie = MutableLiveData<Resource<PagedList<MovieEntity>>>()
        movie.value = Resource.success(movieCourses)

        `when`(allRepository.getAllMovie()).thenReturn(movie)

        viewModel.getMovie().observeForever(observer)
        Mockito.verify(observer).onChanged(movie.value)

        val moviesValue = movie.value
        val actualValue = viewModel.getMovie().value
        assertEquals(moviesValue, actualValue)
        assertEquals(moviesValue?.data, actualValue?.data)
        assertEquals(moviesValue?.data?.size, actualValue?.data?.size)
    }

    @Test
    fun `getCourses should be success but data is empty`() {
        val moviesCourses = PagedTestDataSources.snapshot()
        val movies = MutableLiveData<Resource<PagedList<MovieEntity>>>()
        movies.value = Resource.success(moviesCourses)

        `when`(allRepository.getAllMovie()).thenReturn(movies)

        viewModel.getMovie().observeForever(observer)
        Mockito.verify(observer).onChanged(movies.value)

        val actualValueDataSize = viewModel.getMovie().value?.data?.size
        Assert.assertTrue(
                "size of data should be 0, actual is $actualValueDataSize",
                actualValueDataSize == 0
        )
    }

    @Test
    fun `getCourses should be error`() {
        val moviesMessage = "Something happen dude!"
        val movies = MutableLiveData<Resource<PagedList<CourseEntity>>>()
        movies.value = Resource.error(moviesMessage, null)

        `when`(moviesRepository.getAllCourses()).thenReturn(movies)

        viewModel.getCourses().observeForever(observer)
        Mockito.verify(observer).onChanged(movies.value)

        val actualMessage = viewModel.getCourses().value?.message
        assertEquals(moviesMessage, actualMessage)
    }

    class PagedTestDataSources private constructor(private val items: List<CourseEntity>) : PositionalDataSource<CourseEntity>() {
        companion object {
            fun snapshot(items: List<CourseEntity> = listOf()): PagedList<CourseEntity> {
                return PagedList.Builder(PagedTestDataSources(items), 10)
                        .setNotifyExecutor(Executors.newSingleThreadExecutor())
                        .setFetchExecutor(Executors.newSingleThreadExecutor())
                        .build()
            }
        }

        override fun loadInitial(
                params: LoadInitialParams,
                callback: LoadInitialCallback<CourseEntity>
        ) {
            callback.onResult(items, 0, items.size)
        }

        override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<CourseEntity>) {
            val start = params.startPosition
            val end = params.startPosition + params.loadSize
            callback.onResult(items.subList(start, end))
        }
    }
}