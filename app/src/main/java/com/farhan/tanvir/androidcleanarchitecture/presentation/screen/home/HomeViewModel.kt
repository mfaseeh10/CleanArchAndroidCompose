package com.farhan.tanvir.androidcleanarchitecture.presentation.screen.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.farhan.tanvir.domain.model.MovieList
import com.farhan.tanvir.domain.useCase.GetNowPlayingUseCase
import com.farhan.tanvir.domain.useCase.GetPopularMoviesUseCase
import com.farhan.tanvir.domain.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase,
    private val getNowPlayingUseCase: GetNowPlayingUseCase
) : ViewModel() {
    private val _popularMovieState = mutableStateOf<Result<MovieList>>(Result.Loading())
    val popularMovieState: State<Result<MovieList>> = _popularMovieState

    private val _nowPlayingState = mutableStateOf<Result<MovieList>>(Result.Loading())
    val nowPlayingState: State<Result<MovieList>> = _nowPlayingState
    init {
        getPopularMovies()
        getNowPlaying()
    }

    private fun getPopularMovies() {
        viewModelScope.launch {
          _popularMovieState.value =  getPopularMoviesUseCase()
        }
    }

    private fun getNowPlaying() {
        viewModelScope.launch {
          _nowPlayingState.value =  getNowPlayingUseCase()
        }
    }
}