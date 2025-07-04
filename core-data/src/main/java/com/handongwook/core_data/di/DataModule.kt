package com.handongwook.core_data.di

import com.handongwook.core_data.NetworkCoroutineExceptionHandler
import com.handongwook.core_data.NetworkCoroutineExceptionHandlerImpl
import com.handongwook.core_data.repository.character.CharacterRepository
import com.handongwook.core_data.repository.character.CharacterRepositoryImpl
import com.handongwook.core_network.di.HarryPotterAppDispatchers
import com.handongwook.core_network.di.dispatchersModule
import com.handongwook.core_network.di.networkModule
import org.koin.core.qualifier.named
import org.koin.dsl.bind
import org.koin.dsl.module

val dataModule = module {
    includes(dispatchersModule)
    includes(networkModule)

    single {
        CharacterRepositoryImpl(
            characterService = get(),
            ioDispatcher = get(named(HarryPotterAppDispatchers.IO))
        )
    } bind CharacterRepository::class

    single {
        NetworkCoroutineExceptionHandlerImpl()
    } bind NetworkCoroutineExceptionHandler::class
}