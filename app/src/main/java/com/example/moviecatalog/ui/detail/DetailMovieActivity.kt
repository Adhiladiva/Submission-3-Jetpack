package com.example.moviecatalog.ui.detail

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.moviecatalog.R
import com.example.moviecatalog.data.MovieEntity
import com.example.moviecatalog.databinding.ActivityDetailMovieBinding
import com.example.moviecatalog.databinding.ContentDetailMovieBinding
import com.example.moviecatalog.viewmodel.ViewModelFactory
import com.example.moviecatalog.vo.Status

class DetailMovieActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
        const val EXTRA_TV_SHOW = "extra_tv_show"
    }

    private lateinit var activityDetailMovieBinding: ActivityDetailMovieBinding
    private lateinit var detailContentBinding: ContentDetailMovieBinding

    private lateinit var movieViewModel: DetailMovieViewModel
    private lateinit var tvShowViewModel: DetailTvShowViewModel
    private var menu: Menu? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityDetailMovieBinding = ActivityDetailMovieBinding.inflate(layoutInflater)
        detailContentBinding = activityDetailMovieBinding.detailContent

        setContentView(activityDetailMovieBinding.root)

        setSupportActionBar(activityDetailMovieBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val factory = ViewModelFactory.getInstance(this)

        movieViewModel = ViewModelProvider(this, factory)[DetailMovieViewModel::class.java]
        tvShowViewModel = ViewModelProvider(this, factory)[DetailTvShowViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val movieId = extras.getString(EXTRA_MOVIE)
            val tvShowId = extras.getString(EXTRA_TV_SHOW)

            if (movieId != null) {
                movieViewModel.setSelectedCourse(movieId)
                movieViewModel.courseModule.observe(this, { courseWithModuleResource ->
                    if (courseWithModuleResource != null) {
                        when (courseWithModuleResource.status) {
                            Status.LOADING -> activityDetailMovieBinding.progressBar.visibility =
                                View.VISIBLE
                            Status.SUCCESS -> if (courseWithModuleResource.data != null) {
                                activityDetailMovieBinding.progressBar.visibility = View.GONE
                                activityDetailMovieBinding.content.visibility = View.VISIBLE
                                populateCourse(courseWithModuleResource.data)
                            }
                            Status.ERROR -> {
                                activityDetailMovieBinding.progressBar.visibility = View.GONE
                                Toast.makeText(
                                    applicationContext,
                                    "Terjadi kesalahan",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    }
                })
            }

            if (tvShowId != null) {
                tvShowViewModel.setSelectedCourse(tvShowId)
                tvShowViewModel.courseModule.observe(this, { courseWithModuleResource ->
                    if (courseWithModuleResource != null) {
                        when (courseWithModuleResource.status) {
                            Status.LOADING -> activityDetailMovieBinding.progressBar.visibility =
                                View.VISIBLE
                            Status.SUCCESS -> if (courseWithModuleResource.data != null) {
                                activityDetailMovieBinding.progressBar.visibility = View.GONE
                                activityDetailMovieBinding.content.visibility = View.VISIBLE
                                populateCourse(courseWithModuleResource.data)
                            }
                            Status.ERROR -> {
                                activityDetailMovieBinding.progressBar.visibility = View.GONE
                                Toast.makeText(
                                    applicationContext,
                                    "Terjadi kesalahan",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    }
                })
            }
        }
    }

    private fun populateCourse(courseEntity: MovieEntity) {
        detailContentBinding.textTitle.text = courseEntity.title
        detailContentBinding.overviewText.text = courseEntity.overview
        detailContentBinding.genre.text = courseEntity.genre
        detailContentBinding.duration.text = courseEntity.duration
        detailContentBinding.released.text = courseEntity.released

        Glide.with(this)
                .load(courseEntity.imagePath)
                .transform(RoundedCorners(20))
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                .into(detailContentBinding.imagePoster)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        this.menu = menu
        movieViewModel.courseModule.observe(this, { courseWithModule ->
            if (courseWithModule != null) {
                when (courseWithModule.status) {
                    Status.LOADING -> activityDetailMovieBinding.progressBar.visibility = View.VISIBLE
                    Status.SUCCESS -> if (courseWithModule.data != null) {
                        activityDetailMovieBinding.progressBar.visibility = View.GONE
                        val state = courseWithModule.data.favorite
                        setFavoriteState(state)
                    }
                    Status.ERROR -> {
                        activityDetailMovieBinding.progressBar.visibility = View.GONE
                        Toast.makeText(applicationContext, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
        tvShowViewModel.courseModule.observe(this, { courseWithModule ->
            if (courseWithModule != null) {
                when (courseWithModule.status) {
                    Status.LOADING -> activityDetailMovieBinding.progressBar.visibility = View.VISIBLE
                    Status.SUCCESS -> if (courseWithModule.data != null) {
                        activityDetailMovieBinding.progressBar.visibility = View.GONE
                        val state = courseWithModule.data.favorite
                        setFavoriteState(state)
                    }
                    Status.ERROR -> {
                        activityDetailMovieBinding.progressBar.visibility = View.GONE
                        Toast.makeText(applicationContext, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.favorite_detail) {
            movieViewModel.setFavorite()
            tvShowViewModel.setFavorite()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
    private fun setFavoriteState(state: Boolean) {
        if (menu == null) return
        val menuItem = menu?.findItem(R.id.favorite_detail)
        if (state) {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_favorite)
        } else {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_dont_favorite)
        }
    }
}


