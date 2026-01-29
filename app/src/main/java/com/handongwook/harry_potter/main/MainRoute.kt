package com.handongwook.harry_potter.main

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.handongwook.harry_potter.core.navigation.Characters
import com.handongwook.harry_potter.core.navigation.Details
import com.handongwook.harry_potter.feature.characters.CharactersScreen
import com.handongwook.harry_potter.feature.details.CharacterDetailsScreen
import timber.log.Timber

@Composable
fun MainRoute(
    innerPadding: PaddingValues
) {
    val backStack = rememberNavBackStack(Characters)

    NavDisplay(
        backStack = backStack,
        entryProvider = entryProvider {
            entry<Characters> {
                CharactersScreen(
                    onNavigateToDetail = { characterId ->
                        backStack.add(Details(characterId))
                    }
                )
            }
            entry<Details> { (characterId) ->
                Timber.e("entry<Details> characterId:$characterId")
                CharacterDetailsScreen(
                    characterId = characterId,
                    onNavigateBack = {
                        backStack.removeLast()
                    }
                )
            }
        })
}
