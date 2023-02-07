package com.farhan.tanvir.domain.useCase

import com.farhan.tanvir.domain.repository.MovieRepository


class GetNowPlayingUseCase(private val movieRepository: MovieRepository) {
    suspend operator fun invoke()=movieRepository.getNowPlaying()
}