package com.handongwook.harry_potter.data.di

import com.handongwook.harry_potter.data.NetworkCoroutineExceptionHandler
import com.handongwook.harry_potter.data.NetworkCoroutineExceptionHandlerImpl
import com.handongwook.harry_potter.data.repository.character.CharacterRepository
import com.handongwook.harry_potter.data.repository.character.CharacterRepositoryImpl
import com.handongwook.harry_potter.network.di.HarryPotterAppDispatchers
import com.handongwook.harry_potter.network.di.dispatchersModule
import com.handongwook.harry_potter.network.di.networkModule
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