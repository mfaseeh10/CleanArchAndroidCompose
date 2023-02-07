package com.farhan.tanvir.androidcleanarchitecture.presentation.components

import androidx.compose.foundation.layout.*
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
fun CustomSectionHeader(
    title: String,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start,

    ) {
       Spacer(modifier = Modifier.padding(10.dp))
        Text(
            text = title,
            color = MaterialTheme.colors.titleColor,
            fontWeight = FontWeight.W600
        )
    }

}

@Preview
@Composable
fun prevSectionHeader() {
    CustomSectionHeader(title = "Popular Movies",)
}
