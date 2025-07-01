package com.handongwook.core_data.di

import com.handongwook.core_data.repository.character.CharacterRepository
import com.handongwook.core_data.repository.character.CharacterRepositoryImpl
import com.handongwook.core_network.di.HarryPotterAppDispatchers
import org.koin.core.qualifier.named
import org.koin.dsl.bind
import org.koin.dsl.module

val dataModule = module {
    single {
        CharacterRepositoryImpl(
            characterService = get(),
            ioDispatcher = get(named(HarryPotterAppDispatchers.IO))
        )
    } bind CharacterRepository::class
}