package com.example.moviecatalog.data

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movieEntities")
data class MovieEntity (
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "courseId")
    var courseId: String,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "overview")
    var overview: String,

    @ColumnInfo(name = "released")
    var released: String,

    @ColumnInfo(name = "duration")
    var duration: String,

    @ColumnInfo(name = "genre")
    var genre: String,

    @ColumnInfo(name = "imagePath")
    var imagePath: String,

    @ColumnInfo(name = "favorite")
    var favorite: Boolean = false,
)
