package com.handongwook.harry_potter.feature.characters.di

import com.handongwook.harry_potter.core.viewmodel.di.viewmodelModule
import com.handongwook.harry_potter.core.data.NetworkCoroutineExceptionHandler
import com.handongwook.harry_potter.core.data.di.dataModule
import com.handongwook.harry_potter.feature.characters.CharactersViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val charactersModule = module {
    includes(dataModule)
    includes(viewmodelModule)

    viewModel { CharactersViewModel(get<NetworkCoroutineExceptionHandler>(), get()) }
}