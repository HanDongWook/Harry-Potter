package com.handongwook.harry_potter.feature.characters.appbar

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.handongwook.harry_potter.feature.characters.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharactersAppBar() {
    TopAppBar(
        title = {
            Text(
                modifier = Modifier.padding(start = 6.dp),
                text = stringResource(id = R.string.main_title),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }
    )
}

@Preview
@Composable
private fun CharactersAppBarPreview() {
    CharactersAppBar()
}