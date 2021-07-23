package com.madesubs.core.data.remote.network

import com.madesubs.core.data.remote.response.ListMovieResponse
import retrofit2.http.GET

interface ApiService {
    @GET("search/movie?api_key=2489234a3ec616f66070410cf55c6bcb&language=en-US&page=1&include_adult=false&query=a")
    suspend fun getList(): ListMovieResponse
}