package com.handongwook.harry_potter.feature.details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.handongwook.harry_potter.core.model.Character
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterDetailsScreen(
    characterId: String,
    onNavigateBack: () -> Unit = {},
    viewModel: DetailsViewModel = koinViewModel { parametersOf(characterId) }
) {
    val state by viewModel.collectAsState()

    viewModel.collectSideEffect { sideEffect ->
        when (sideEffect) {
            is DetailsSideEffect.NavigateBack -> {
                onNavigateBack()
            }
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = state.character?.name ?: "Character Details",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = viewModel::onBackClick) {
                        Text(
                            text = "←",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            when {
                state.isLoading -> {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
                state.error != null -> {
                    Text(
                        text = "Error: ${state.error}",
                        modifier = Modifier.align(Alignment.Center),
                        color = MaterialTheme.colorScheme.error
                    )
                }
                state.character != null -> {
                    CharacterDetailsContent(character = state.character!!)
                }
            }
        }
    }
}

@Composable
fun CharacterDetailsContent(character: Character) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        // Character Image
        AsyncImage(
            model = character.imageUrl,
            contentDescription = character.name,
            modifier = Modifier
                .size(200.dp)
                .align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Character Name
        Text(
            text = character.name,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Alternate Names
        if (character.alternateNames.isNotEmpty()) {
            Text(
                text = character.alternateNames.joinToString(", "),
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Character Details
        DetailRow(label = "House", value = character.house.ifEmpty { "Unknown" })
        DetailRow(label = "Species", value = character.species.ifEmpty { "Unknown" })
        DetailRow(label = "Gender", value = character.gender.ifEmpty { "Unknown" })
        DetailRow(label = "Date of Birth", value = character.dateOfBirth ?: "Unknown")
        DetailRow(label = "Wizard", value = if (character.wizard) "Yes" else "No")
        DetailRow(label = "Ancestry", value = character.ancestry.ifEmpty { "Unknown" })
        DetailRow(label = "Eye Colour", value = character.eyeColour.ifEmpty { "Unknown" })
        DetailRow(label = "Hair Colour", value = character.hairColour.ifEmpty { "Unknown" })
        DetailRow(label = "Patronus", value = character.patronus.ifEmpty { "Unknown" })
        DetailRow(label = "Hogwarts Student", value = if (character.hogwartsStudent) "Yes" else "No")
        DetailRow(label = "Hogwarts Staff", value = if (character.hogwartsStaff) "Yes" else "No")
        DetailRow(label = "Actor", value = character.actor.ifEmpty { "Unknown" })
        DetailRow(label = "Alive", value = if (character.alive) "Yes" else "No")

        // Wand Details
        if (character.wand.wood.isNotEmpty() || character.wand.core.isNotEmpty()) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Wand",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            DetailRow(label = "Wood", value = character.wand.wood.ifEmpty { "Unknown" })
            DetailRow(label = "Core", value = character.wand.core.ifEmpty { "Unknown" })
            if (character.wand.length != null) {
                DetailRow(label = "Length", value = "${character.wand.length}\"")
            }
        }
    }
}

@Composable
fun DetailRow(label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = value,
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.weight(1f)
        )
    }
}
