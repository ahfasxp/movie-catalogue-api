package com.ahfasxp.moviecatalogue.core.utils

import com.ahfasxp.moviecatalogue.core.data.source.local.entity.MainEntity
import com.ahfasxp.moviecatalogue.core.data.source.remote.response.MovieResponse
import com.ahfasxp.moviecatalogue.core.data.source.remote.response.ShowResponse
import com.ahfasxp.moviecatalogue.core.domain.model.Catalogue

object DataMapper {
    fun mapResponsesMovieToEntities(input: List<MovieResponse>): List<MainEntity> {
        val mainList = ArrayList<MainEntity>()
        input.map {
            val main = MainEntity(
                id = it.id,
                title = it.title,
                tagline = it.tagline,
                overview = it.overview,
                poster_path = it.poster_path,
                isFavorite = false,
                type = "movie"
            )
            mainList.add(main)
        }
        return mainList
    }

    fun mapResponsesShowToEntities(input: List<ShowResponse>): List<MainEntity> {
        val mainList = ArrayList<MainEntity>()
        input.map {
            val main = MainEntity(
                id = it.id,
                title = it.title,
                tagline = it.tagline,
                overview = it.overview,
                poster_path = it.poster_path,
                isFavorite = false,
                type = "show"
            )
            mainList.add(main)
        }
        return mainList
    }

    fun mapEntitiesToDomain(input: List<MainEntity>): List<Catalogue> =
        input.map {
            Catalogue(
                id = it.id,
                title = it.title,
                tagline = it.tagline,
                overview = it.overview,
                poster_path = it.poster_path,
                isFavorite = it.isFavorite,
                type = it.type
            )
        }

    fun mapDomainToEntity(input: Catalogue) = MainEntity(
        id = input.id,
        title = input.title,
        tagline = input.tagline,
        overview = input.overview,
        poster_path = input.poster_path,
        isFavorite = input.isFavorite,
        type = input.type
    )
}