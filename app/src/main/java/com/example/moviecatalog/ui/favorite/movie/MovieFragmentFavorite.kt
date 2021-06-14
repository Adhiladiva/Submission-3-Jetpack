package com.example.moviecatalog.ui.favorite.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviecatalog.R
import com.example.moviecatalog.data.MovieEntity
import com.example.moviecatalog.databinding.FragmentMovieFavoriteBinding
import com.example.moviecatalog.viewmodel.ViewModelFactory
import com.google.android.material.snackbar.Snackbar

class MovieFragmentFavorite : Fragment() {
    lateinit var fragmentMovieFavoriteBinding: FragmentMovieFavoriteBinding

    private lateinit var viewModel: MovieFavoriteViewModel
    private lateinit var movieAdapter: MovieFavoriteAdapter


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        fragmentMovieFavoriteBinding = FragmentMovieFavoriteBinding.inflate(layoutInflater, container, false)
        return fragmentMovieFavoriteBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemTouchHelper.attachToRecyclerView(fragmentMovieFavoriteBinding?.rvMovieFavorite)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[MovieFavoriteViewModel::class.java]
            val adapter = MovieFavoriteAdapter()

            fragmentMovieFavoriteBinding.progressBar.visibility = View.VISIBLE
            viewModel.getMovieFavorite().observe(this, { courses ->
                fragmentMovieFavoriteBinding.progressBar.visibility = View.GONE
                adapter.submitList(courses)
            })

            fragmentMovieFavoriteBinding?.rvMovieFavorite?.layoutManager = LinearLayoutManager(context)
            fragmentMovieFavoriteBinding?.rvMovieFavorite?.setHasFixedSize(true)
            fragmentMovieFavoriteBinding?.rvMovieFavorite?.adapter = adapter
        }
    }

    private val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.Callback() {
        override fun getMovementFlags(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder): Int =
            makeMovementFlags(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)

        override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean = true

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            if (view != null) {
                val swipedPosition = viewHolder.adapterPosition
                val courseEntity = movieAdapter.getSwipedData(swipedPosition)
                courseEntity?.let { viewModel.setFavoriteMovie(it) }

                val snackbar = Snackbar.make(view as View, R.string.message_undo, Snackbar.LENGTH_LONG)
                snackbar.setAction(R.string.message_ok) { v ->
                    courseEntity?.let { viewModel.setFavoriteMovie(it) }
                }
                snackbar.show()
            }
        }
    })
}