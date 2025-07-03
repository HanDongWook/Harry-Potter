package com.handongwook.harry_potter.main

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import com.handongwook.harry_potter.feature.characters.CharactersScreen

@Composable
fun MainRoute(
    innerPadding: PaddingValues
) {
    CharactersScreen(
        innerPadding = innerPadding,
    )
}