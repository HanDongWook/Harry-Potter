package com.handongwook.harry_potter.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.handongwook.harry_potter.ui.characters.CharactersScreen
import com.handongwook.harry_potter.ui.characters.CharactersViewModel
import com.handongwook.harry_potter.ui.theme.HarrypotterTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    private val charactersViewModel: CharactersViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HarrypotterTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CharactersScreen(
                        innerPadding = innerPadding,
                        viewModel = charactersViewModel
                    )
                }
            }
        }
    }
}
