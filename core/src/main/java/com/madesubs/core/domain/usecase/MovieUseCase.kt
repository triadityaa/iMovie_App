package com.madesubs.core.domain.usecase

import com.madesubs.core.data.Resource
import com.madesubs.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieUseCase {
    fun getAllMovie(): Flow<Resource<List<Movie>>>

    fun getFavoriteMovie(): Flow<List<Movie>>

    fun setFavoriteMovie(movie: Movie, status: Boolean)
}