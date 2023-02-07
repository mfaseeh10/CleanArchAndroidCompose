package com.farhan.tanvir.androidcleanarchitecture.presentation.screen.home


import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.farhan.tanvir.androidcleanarchitecture.R
import com.farhan.tanvir.androidcleanarchitecture.presentation.components.*
import com.farhan.tanvir.androidcleanarchitecture.ui.theme.appBackgroundColor
import com.farhan.tanvir.androidcleanarchitecture.ui.theme.statusBarColor
import com.farhan.tanvir.androidcleanarchitecture.ui.theme.titleColor
import com.farhan.tanvir.androidcleanarchitecture.ui.theme.topAppbarBackgroundColor
import com.farhan.tanvir.domain.util.Result
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(navController: NavHostController, viewModel: HomeViewModel = hiltViewModel()) {

    val systemUiController = rememberSystemUiController()
    val systemBarColor = MaterialTheme.colors.statusBarColor
    val titleColor = MaterialTheme.colors.titleColor
    val topAppbarBackgroundColor = MaterialTheme.colors.topAppbarBackgroundColor
    val appBackgroundColor = MaterialTheme.colors.appBackgroundColor

    SideEffect {
        systemUiController.setStatusBarColor(
            color = systemBarColor
        )
    }
    Scaffold(
        backgroundColor = appBackgroundColor,
        topBar = {
            CustomAppBar(
                titleColor = titleColor,
                topAppbarBackgroundColor = topAppbarBackgroundColor
            )
        }
    ) {
        Column()
        {
            CustomSectionHeader(title = "Now Showing")
            NowPlayingMovies(viewModel)
            CustomSectionHeader(title = "Popular")
            Spacer(modifier = Modifier.fillMaxWidth())
            PopularMoviesList(viewModel)

        }


    }
}


@Composable
fun PopularMoviesList(viewModel: HomeViewModel = hiltViewModel()){
    when (val movieResponse = viewModel.popularMovieState.value) {
        is Result.Loading -> ProgressBar()
        is Result.Success -> LazyColumn(
            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 16.dp)
        ) {
            movieResponse.data?.let { movieList ->
                items(
                    items = movieList.movies,
                    itemContent = {
                        MovieListItem(movie = it)
                    }
                )
            }
        }
        is Result.Error -> Toast.makeText(
            LocalContext.current,
            stringResource(R.string.toast_error),
            Toast.LENGTH_SHORT
        )
    }
}
@Composable
fun NowPlayingMovies(viewModel: HomeViewModel = hiltViewModel()){
    when (val movieResponse = viewModel.nowPlayingState.value) {
        is Result.Loading -> ProgressBar()
        is Result.Success -> LazyRow(
            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            movieResponse.data?.let { movieList ->
                items(
                    items = movieList.movies,
                    itemContent = {
                        NowPlayingListItem(movie = it)
                    }
                )
            }
        }
        is Result.Error -> Toast.makeText(
            LocalContext.current,
            stringResource(R.string.toast_error),
            Toast.LENGTH_SHORT
        )
    }
}

