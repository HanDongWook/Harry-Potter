package com.handongwook.harry_potter.feature.details.di

import com.handongwook.harry_potter.core.data.NetworkCoroutineExceptionHandler
import com.handongwook.harry_potter.core.data.di.dataModule
import com.handongwook.harry_potter.core.viewmodel.di.viewmodelModule
import com.handongwook.harry_potter.feature.details.DetailsViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val detailsModule = module {
    includes(dataModule)
    includes(viewmodelModule)

    viewModel { (characterId: String) ->
        DetailsViewModel(
            coroutineExceptionHandler = get<NetworkCoroutineExceptionHandler>(),
            characterRepository = get(),
            characterId = characterId
        )
    }
}