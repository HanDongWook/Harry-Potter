package com.handongwook.harry_potter.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.handongwook.harry_potter.theme.HarrypotterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HarrypotterTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainRoute(innerPadding)
                }
            }
        }
    }
}
