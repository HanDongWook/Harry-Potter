package com.handongwook.harry_potter.feature.characters

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.handongwook.harry_potter.core.model.Character
import com.handongwook.harry_potter.feature.characters.appbar.CharactersAppBar
import org.koin.androidx.compose.koinViewModel
import org.orbitmvi.orbit.compose.collectAsState

@Composable
fun CharactersScreen(
    viewModel: CharactersViewModel = koinViewModel(),
    onNavigateToDetail: (String) -> Unit = {}
) {
    val state by viewModel.collectAsState()

    viewModel.container.sideEffectFlow.collectAsState(initial = null).value?.let { sideEffect ->
        when (sideEffect) {
            is CharactersSideEffect.NavigateToDetail -> {
                onNavigateToDetail(sideEffect.characterId)
            }
        }
    }

    Column(modifier = Modifier.fillMaxSize()) {
        CharactersAppBar()
        CharactersContent(
            characters = state.characters,
            fetchNextItems = viewModel::fetchNextCharacters,
            onCharacterClick = viewModel::onCharacterClick
        )
    }
}

@Composable
fun CharactersContent(
    characters: List<Character>,
    fetchNextItems: () -> Unit,
    onCharacterClick: (String) -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        val threadHold = 8
        LazyVerticalGrid(
            modifier = Modifier.testTag("Characters"),
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(6.dp),
        ) {
            itemsIndexed(
                items = characters,
                key = { _, character -> character.name }) { index, character ->
//                if ((index + threadHold) >= characters.size && uiState != HomeUiState.Loading) {
//                    fetchNextItems()
//                }

                CharactersItem(
                    character = character,
                    onCharacterClick = onCharacterClick
                )
            }
        }
    }
}

@Composable
fun CharactersItem(
    character: Character,
    backgroundColor: Color = Color.White,
    onCharacterClick: (String) -> Unit = {}
) {
    Card(
        modifier = Modifier
            .padding(6.dp)
            .fillMaxWidth()
            .testTag("Character")
            .clickable {
                onCharacterClick(character.id)
            },
        shape = RoundedCornerShape(14.dp),
        colors = CardColors(
            containerColor = backgroundColor,
            contentColor = backgroundColor,
            disabledContainerColor = backgroundColor,
            disabledContentColor = backgroundColor,
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
    ) {
        AsyncImage(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 20.dp)
                .size(120.dp),
            model = character.imageUrl,
            contentDescription = character.name
        )

        Text(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .padding(12.dp),
            text = character.name,
            color = Color.Black,
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
        )
    }
}