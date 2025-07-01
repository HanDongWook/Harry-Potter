package com.handongwook.harry_potter.di

import com.handongwook.harry_potter.ui.characters.CharactersViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { CharactersViewModel(get()) }
}