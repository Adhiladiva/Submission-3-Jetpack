package com.example.moviecatalog.data.source.remote.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CourseResponse(
    var id: String,
    var title: String,
    var overview: String,
    var released: String,
    var duration: String,
    var genre: String,
    var imagePath: String
) : Parcelable