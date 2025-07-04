package com.handongwook.harry_potter.feature.characters.di

import com.dongwook.core_viewmodel.di.viewmodelModule
import com.handongwook.core_data.NetworkCoroutineExceptionHandler
import com.handongwook.core_data.di.dataModule
import com.handongwook.harry_potter.feature.characters.CharactersViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val charactersModule = module {
    includes(dataModule)
    includes(viewmodelModule)

    viewModel { CharactersViewModel(get<NetworkCoroutineExceptionHandler>(), get()) }
}