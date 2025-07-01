package com.handongwook.harry_potter.ui.characters.appbar

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.handongwook.harry_potter.R
import com.handongwook.harry_potter.ui.theme.HarrypotterTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharactersAppBar() {
    TopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.app_name),
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
            )
        },
        colors = TopAppBarDefaults.topAppBarColors().copy(
            containerColor = Color.Black,
        ),
    )
}

@Preview
@Composable
private fun PokedexAppBarPreview() {
    HarrypotterTheme {
        CharactersAppBar()
    }
}