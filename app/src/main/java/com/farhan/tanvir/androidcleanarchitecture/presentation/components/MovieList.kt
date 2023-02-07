package com.farhan.tanvir.androidcleanarchitecture.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import coil.size.Scale
import com.farhan.tanvir.androidcleanarchitecture.BuildConfig
import com.farhan.tanvir.androidcleanarchitecture.R
import com.farhan.tanvir.domain.model.Movie

@OptIn(coil.annotation.ExperimentalCoilApi::class)
@Composable
fun MovieListItem(movie: Movie) {
    Card(
        modifier = Modifier
            .padding(top = 8.dp, start = 10.dp, end = 10.dp)
            .fillMaxWidth(),
        elevation = 8.dp,

        ) {
        Row(
            modifier = Modifier
                .height(IntrinsicSize.Max)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            //Image
            movie.posterPath?.let {
                Image(
                    modifier = Modifier
                        .padding(
                            end = 4.dp,
                        )
                        .width(120.dp),
                    painter = rememberImagePainter(
                        data = BuildConfig.POSTER_URL + movie.posterPath, builder = {
                            crossfade(true)
                            scale(Scale.FIT)
                        }),
                    contentDescription = null,
                    contentScale = ContentScale.FillHeight
                )
            }
            //Title and description
            Column(Modifier.height(IntrinsicSize.Max)) {
                movie.title?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.subtitle1,
                        fontWeight = FontWeight.W600
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                movie.overview?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.body2,
                        maxLines = 3,
                        overflow = TextOverflow.Ellipsis,
                        fontSize = 12.sp,
                        fontStyle = FontStyle.Italic
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_star_rate),
                        contentDescription = null
                    )
                    movie.rating?.let {
                        Text(text = it, style = MaterialTheme.typography.subtitle1)
                    }
                }
                Spacer(modifier = Modifier.height(4.dp))
            }
        }
    }
}


@Preview
@Composable
private fun PrevListItem() {

    val movie = Movie(
        21,
        "Amazing movie of horror",
        "/rjkmN1dniUHVYAtwuV3Tji7FsDO.jpg",
        "Venom: Let there be Carnage",
        "5"
    )

    MovieListItem(movie = movie)

}