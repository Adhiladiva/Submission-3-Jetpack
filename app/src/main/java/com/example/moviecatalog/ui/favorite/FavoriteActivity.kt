package com.example.moviecatalog.ui.favorite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.moviecatalog.databinding.ActivityFavoriteBinding

class FavoriteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityFavoriteBinding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(activityFavoriteBinding.root)

        val favoriteSectionsPagerAdapter = FavoriteSectionPagerAdapter(this, supportFragmentManager)
        activityFavoriteBinding.viewPager.adapter = favoriteSectionsPagerAdapter
        activityFavoriteBinding.tabs.setupWithViewPager(activityFavoriteBinding.viewPager)

        supportActionBar?.elevation = 0f
    }
}