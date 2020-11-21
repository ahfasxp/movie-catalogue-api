package com.ahfasxp.moviecatalogue.core.domain.usecase

import androidx.lifecycle.LiveData
import com.ahfasxp.moviecatalogue.core.domain.model.Catalogue
import com.ahfasxp.moviecatalogue.core.domain.repository.ICatalogueRepository
import com.ahfasxp.moviecatalogue.core.vo.Resource

class CatalogueInteractor(private val catalogueRepository: ICatalogueRepository) :
    CatalogueUseCase {
    override fun getAllMovies() = catalogueRepository.getAllMovies()

    override fun getAllShows() = catalogueRepository.getAllShows()

    override fun getFavoriteMovie() = catalogueRepository.getFavoriteMovie()

    override fun getFavoriteShow() = catalogueRepository.getFavoriteShow()

    override fun setFavorite(main: Catalogue, state: Boolean) =
        catalogueRepository.setFavorite(main, state)
}