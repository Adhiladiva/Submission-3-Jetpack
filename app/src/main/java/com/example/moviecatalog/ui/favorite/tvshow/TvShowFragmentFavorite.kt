package com.example.moviecatalog.ui.favorite.tvshow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ShareCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviecatalog.R
import com.example.moviecatalog.data.MovieEntity
import com.example.moviecatalog.databinding.FragmentTvShowBinding
import com.example.moviecatalog.databinding.FragmentTvShowFavoriteBinding
import com.example.moviecatalog.utils.DataDummy
import com.example.moviecatalog.viewmodel.ViewModelFactory
import com.google.android.material.snackbar.Snackbar

class TvShowFragmentFavorite : Fragment() {

    lateinit var fragmentTvShowFavoriteBinding: FragmentTvShowFavoriteBinding

    private lateinit var viewModel: TvShowFavoriteViewModel
    private lateinit var tvShowadapter: TvShowFavoriteAdapter


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        fragmentTvShowFavoriteBinding = FragmentTvShowFavoriteBinding.inflate(inflater, container, false)
        return fragmentTvShowFavoriteBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemTouchHelper.attachToRecyclerView(fragmentTvShowFavoriteBinding?.rvTvShowFavorite)

        if (activity != null) {

            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[TvShowFavoriteViewModel::class.java]

            val adapter = TvShowFavoriteAdapter()

            fragmentTvShowFavoriteBinding.progressBar.visibility = View.VISIBLE
            viewModel.getTvShowFavorite().observe(this, { courses ->
                fragmentTvShowFavoriteBinding.progressBar.visibility = View.GONE
                adapter.submitList(courses)
            })

            fragmentTvShowFavoriteBinding?.rvTvShowFavorite?.layoutManager = LinearLayoutManager(context)
            fragmentTvShowFavoriteBinding?.rvTvShowFavorite?.setHasFixedSize(true)
            fragmentTvShowFavoriteBinding?.rvTvShowFavorite?.adapter = adapter
            }
        }

    private val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.Callback() {
        override fun getMovementFlags(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder): Int =
            makeMovementFlags(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)

        override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean = true

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            if (view != null) {
                val swipedPosition = viewHolder.adapterPosition
                val courseEntity = tvShowadapter.getSwipedData(swipedPosition)
                courseEntity?.let { viewModel.setFavoriteTvShow(it) }

                val snackbar = Snackbar.make(view as View, R.string.message_undo, Snackbar.LENGTH_LONG)
                snackbar.setAction(R.string.message_ok) { v ->
                    courseEntity?.let { viewModel.setFavoriteTvShow(it) }
                }
                snackbar.show()
            }
        }
    })
}