package com.handongwook.harry_potter.network.di

import kotlinx.coroutines.Dispatchers
import org.koin.core.qualifier.named
import org.koin.dsl.module

enum class HarryPotterAppDispatchers {
    IO,
    Default,
    Main,
    Unconfined
}

val dispatchersModule = module {
    single(named(HarryPotterAppDispatchers.IO)) {
        Dispatchers.IO
    }

    single(named(HarryPotterAppDispatchers.Default)) {
        Dispatchers.Default
    }

    single(named(HarryPotterAppDispatchers.Main)) {
        Dispatchers.Main
    }

    single(named(HarryPotterAppDispatchers.Unconfined)) {
        Dispatchers.Unconfined
    }
}