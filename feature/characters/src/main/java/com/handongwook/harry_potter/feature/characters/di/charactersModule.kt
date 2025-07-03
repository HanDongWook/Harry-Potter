package com.handongwook.harry_potter.feature.characters.di

import com.handongwook.harry_potter.feature.characters.CharactersViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val charactersModule = module {
    viewModel { CharactersViewModel(get()) }
}