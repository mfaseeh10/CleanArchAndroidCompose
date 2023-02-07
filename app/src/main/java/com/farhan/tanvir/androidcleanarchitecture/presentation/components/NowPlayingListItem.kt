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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.ImagePainter.State.Empty.painter
import coil.compose.rememberImagePainter
import coil.size.Scale
import com.farhan.tanvir.androidcleanarchitecture.BuildConfig
import com.farhan.tanvir.androidcleanarchitecture.R
import com.farhan.tanvir.androidcleanarchitecture.ui.theme.YellowStar
import com.farhan.tanvir.domain.model.Movie

@OptIn(coil.annotation.ExperimentalCoilApi::class)
@Composable
fun NowPlayingListItem(movie: Movie) {
    Card(
        modifier = Modifier
            .padding(top = 2.dp, start = 10.dp)
            .height(240.dp),
        elevation = 8.dp,

        ) {
        Column(
            modifier = Modifier
                .width(120.dp)
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
        ) {
            Box(
                modifier = Modifier
                    .height(180.dp)
                    .width(120.dp)
            ) {
                //Image
                movie.posterPath?.let {
                    Image(
                        modifier = Modifier
                            .padding(horizontal = 2.dp)
                            .fillMaxWidth()
                            .fillMaxHeight(),
                        painter = rememberImagePainter(data = BuildConfig.POSTER_URL + movie.posterPath,
                            builder = {
                                crossfade(true)
                                scale(Scale.FILL)
                            }),
                        contentDescription = null,
                        contentScale = ContentScale.Fit
                    )
                }
            }
            Box(
                modifier = Modifier
                    .height(40.dp)
                    .wrapContentSize(align = Alignment.Center)
                    .padding(horizontal = 4.dp, vertical = 2.dp)
            ) {
                movie.title?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.subtitle1,
                        fontWeight = FontWeight.W600,
                        fontSize = 12.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 6.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_star_rate),
                    contentDescription = null,
                    tint = YellowStar,
                    modifier = Modifier
                        .height(12.dp)
                        .width(12.dp)

                )
                Spacer(modifier = Modifier.width(2.dp))
                movie.rating?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.subtitle1,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.W400
                    )
                }
            }
            //Title and description
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

    NowPlayingListItem(movie = movie)

}