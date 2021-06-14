package com.example.moviecatalog.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.moviecatalog.data.MovieEntity
import com.example.moviecatalog.data.source.local.LocalDataSource
import com.example.moviecatalog.data.source.remote.RemoteDataSource
import com.example.moviecatalog.utils.AppExecutors
import com.example.moviecatalog.utils.DataDummy
import com.example.moviecatalog.utils.LiveDataTestUtil
import com.example.moviecatalog.utils.PagedListUtil
import com.example.moviecatalog.vo.Resource
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class AllRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)

    private val movieRepository = FakeAllRepository(remote, local, appExecutors)

    private val movieResponses = DataDummy.generateRemoteDummyMovie()
    private val movieId = movieResponses[0].id

    private val tvShowResponses = DataDummy.generateRemoteDummyTvShow()
    private val tvShowId = tvShowResponses[0].id


    @Test
    fun getAllMovie() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getAllMovie()).thenReturn(dataSourceFactory)
        movieRepository.getAllMovie()


        val courseEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovie()))
        verify(local).getAllMovie()

        assertNotNull(courseEntities.data)
        assertEquals(movieResponses.size.toLong(), courseEntities.data?.size?.toLong())
    }

    @Test
    fun getCourseWithMovie() {
        val dummyEntity = MutableLiveData<MovieEntity>()
        dummyEntity.value = DataDummy.generateDummyMovie()[0]
        `when`(local.getCourseWithModules(movieId)).thenReturn(dummyEntity)

        val resultCourse = LiveDataTestUtil.getValue(movieRepository.getCourseWithMovie(movieId))
        verify(local).getCourseWithModules(movieId)

        assertNotNull(resultCourse.data)
        assertNotNull(resultCourse.data?.title)
        assertEquals(movieResponses[0].title, resultCourse.data?.title)
    }

    @Test
    fun getAllTvShow() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getAllTvShow()).thenReturn(dataSourceFactory)
        movieRepository.getAllTvShow()

        val courseEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTvShow()))
        verify(local).getAllTvShow()

        assertNotNull(courseEntities.data)
        assertEquals(movieResponses.size.toLong(), courseEntities.data?.size?.toLong())
    }

    @Test
    fun getCourseWithTvShow() {
        val dummyEntity = MutableLiveData<MovieEntity>()
        dummyEntity.value = DataDummy.generateDummyTvShow()[0]
        `when`(local.getCourseWithModules(tvShowId)).thenReturn(dummyEntity)


        val resultCourse = LiveDataTestUtil.getValue(movieRepository.getCourseWithTvShow(tvShowId))
        verify(local).getCourseWithModules(tvShowId)

        assertNotNull(resultCourse.data)
        assertNotNull(resultCourse.data?.title)
        assertEquals(tvShowResponses[0].title, resultCourse.data?.title)
    }
}