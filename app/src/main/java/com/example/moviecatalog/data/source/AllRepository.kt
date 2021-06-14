package com.example.moviecatalog.data.source


import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.moviecatalog.data.MovieEntity
import com.example.moviecatalog.data.NetworkBoundResource
import com.example.moviecatalog.data.source.local.LocalDataSource
import com.example.moviecatalog.data.source.remote.ApiResponse
import com.example.moviecatalog.data.source.remote.RemoteDataSource
import com.example.moviecatalog.data.source.remote.response.CourseResponse
import com.example.moviecatalog.utils.AppExecutors
import com.example.moviecatalog.vo.Resource

class AllRepository private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors)
    :AllDataSource {

    companion object {
        @Volatile
        private var instance: AllRepository? = null

        fun getInstance(remoteData: RemoteDataSource, localData: LocalDataSource, appExecutors: AppExecutors): AllRepository =
            instance ?: synchronized(this) {
                instance ?: AllRepository(remoteData, localData, appExecutors).apply {
                    instance = this
                }
            }
    }

    override fun getAllMovie(): LiveData<Resource<PagedList<MovieEntity>>> {
        return object : NetworkBoundResource<PagedList<MovieEntity>, List<CourseResponse>>(appExecutors) {

            public override fun loadFromDB(): LiveData<PagedList<MovieEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllMovie(), config).build()
            }

            override fun shouldFetch(data: PagedList<MovieEntity>?): Boolean =
                data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<CourseResponse>>> =
                remoteDataSource.getAllMovie()

            public override fun saveCallResult(movieResponse: List<CourseResponse>) {
                val movieList = ArrayList<MovieEntity>()
                for (response in movieResponse) {
                    val movie = MovieEntity(
                        response.id,
                        response.title,
                        response.overview,
                        response.released,
                        response.duration,
                        response.genre,
                        response.imagePath
                    )
                    movieList.add(movie)
                }
                localDataSource.insertAll(movieList)
            }
        }.asLiveData()
    }

    override fun getAllTvShow(): LiveData<Resource<PagedList<MovieEntity>>> {
        return object :
            NetworkBoundResource<PagedList<MovieEntity>, List<CourseResponse>>(appExecutors) {
            public override fun loadFromDB(): LiveData<PagedList<MovieEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllTvShow(), config).build()
            }

            override fun shouldFetch(data: PagedList<MovieEntity>?): Boolean =
                data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<CourseResponse>>> =
                remoteDataSource.getAllTvShow()

            public override fun saveCallResult(tvShowResponse: List<CourseResponse>) {
                val tvShowList = ArrayList<MovieEntity>()
                for (response in tvShowResponse) {
                    val tvShow = MovieEntity(
                        response.id,
                        response.title,
                        response.overview,
                        response.released,
                        response.duration,
                        response.genre,
                        response.imagePath
                    )
                    tvShowList.add(tvShow)
                }
                localDataSource.insertAll(tvShowList)
            }
        }.asLiveData()
    }

    override fun getAllFavorite(): LiveData<PagedList<MovieEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getAllFavorite(), config).build()
    }

    override fun getCourseWithMovie(courseId: String): LiveData<Resource<MovieEntity>> {

        return object : NetworkBoundResource<MovieEntity, List<CourseResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<MovieEntity> =
                localDataSource.getCourseWithModules(courseId)

            override fun shouldFetch(courseWithModule: MovieEntity?): Boolean =
                courseWithModule == null

            override fun createCall(): LiveData<ApiResponse<List<CourseResponse>>> =
                remoteDataSource.getAllMovie()

            override fun saveCallResult(movieResponse: List<CourseResponse>) {
                val moduleList = ArrayList<MovieEntity>()
                for (response in movieResponse) {
                    if (response.id == courseId) {
                        val course = MovieEntity(
                            response.id,
                            response.title,
                            response.overview,
                            response.released,
                            response.duration,
                            response.genre,
                            response.imagePath
                        )
                        moduleList.add(course)
                    }
                }
                localDataSource.insertAll(moduleList)
            }
        }.asLiveData()
    }

    override fun getCourseWithTvShow(courseId: String): LiveData<Resource<MovieEntity>> {

        return object : NetworkBoundResource<MovieEntity, List<CourseResponse>>(appExecutors) {

            override fun loadFromDB(): LiveData<MovieEntity> =
                localDataSource.getCourseWithModules(courseId)

            override fun shouldFetch(courseWithModule: MovieEntity?): Boolean =
                courseWithModule == null

            override fun createCall(): LiveData<ApiResponse<List<CourseResponse>>> =
                remoteDataSource.getAllTvShow()

            override fun saveCallResult(tvShowResponse: List<CourseResponse>) {
                val moduleList = ArrayList<MovieEntity>()
                for (response in tvShowResponse) {
                    if (response.id == courseId) {
                        val course = MovieEntity(
                            response.id,
                            response.title,
                            response.overview,
                            response.released,
                            response.duration,
                            response.genre,
                            response.imagePath
                        )
                        moduleList.add(course)
                    }
                }
                localDataSource.insertAll(moduleList)
            }
        }.asLiveData()
    }

    override fun setCourseAll(course: MovieEntity, state: Boolean) {
        appExecutors.diskIO().execute { localDataSource.setAllFavorite(course, state) }
    }
}
