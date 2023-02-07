package com.farhan.tanvir.androidcleanarchitecture.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.farhan.tanvir.androidcleanarchitecture.R
import com.farhan.tanvir.androidcleanarchitecture.ui.theme.statusBarColor
import com.farhan.tanvir.androidcleanarchitecture.ui.theme.titleColor

@Composable
fun CustomAppBar(
    titleColor: Color,
    topAppbarBackgroundColor: Color
) {
    TopAppBar(
        backgroundColor = topAppbarBackgroundColor,
        modifier = Modifier.fillMaxWidth(),
        elevation = 0.dp
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
        ) {
            Text(
                text = stringResource(R.string.app_name),
                color = titleColor,
                fontWeight = FontWeight.W600
            )
        }
    }
}

@Preview
@Composable
fun prevAppBar() {
    val systemBarColor = MaterialTheme.colors.statusBarColor
    val titleColor = MaterialTheme.colors.titleColor

    CustomAppBar(titleColor = titleColor, topAppbarBackgroundColor = systemBarColor)
}
