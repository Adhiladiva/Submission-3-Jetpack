package com.example.moviecatalog.utils

import android.content.Context
import com.example.moviecatalog.data.source.remote.response.CourseResponse
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class JsonHelper(private val context: Context) {

    private fun parsingFileToString(fileName: String): String? {
        return try {
            val `is` = context.assets.open(fileName)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)

        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        }
    }

    fun loadMovie(): List<CourseResponse> {
        val list = ArrayList<CourseResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("Movie.json").toString())
            val listArray = responseObject.getJSONArray("movie")
            for (i in 0 until listArray.length()) {
                val movie = listArray.getJSONObject(i)

                val id = movie.getString("id")
                val title = movie.getString("title")
                val overview = movie.getString("overview")
                val released = movie.getString("released")
                val duration = movie.getString("duration")
                val genre = movie.getString("genre")
                val imagePath = movie.getString("imagePath")

                val movieResponse = CourseResponse(id, title, overview, released, duration, genre, imagePath)
                list.add(movieResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return list
    }

    fun loadTvShow(): List<CourseResponse> {
        val list = ArrayList<CourseResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("TvShow.json").toString())
            val listArray = responseObject.getJSONArray("tvShow")
            for (i in 0 until listArray.length()) {
                val tvShow = listArray.getJSONObject(i)

                val id = tvShow.getString("id")
                val title = tvShow.getString("title")
                val overview = tvShow.getString("overview")
                val released = tvShow.getString("released")
                val duration = tvShow.getString("duration")
                val genre = tvShow.getString("genre")
                val imagePath = tvShow.getString("imagePath")

                val tvShowResponse = CourseResponse(id, title, overview, released, duration, genre, imagePath)
                list.add(tvShowResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return list
    }
}