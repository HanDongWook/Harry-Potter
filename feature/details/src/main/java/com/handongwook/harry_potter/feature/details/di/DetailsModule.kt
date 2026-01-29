package com.handongwook.harry_potter.feature.details.di

import com.handongwook.harry_potter.core.viewmodel.di.viewmodelModule
import com.handongwook.harry_potter.core.data.NetworkCoroutineExceptionHandler
import com.handongwook.harry_potter.core.data.di.dataModule
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val detailsModule = module {
    includes(dataModule)
    includes(viewmodelModule)

    viewModel { DetailsViewModel(get<NetworkCoroutineExceptionHandler>()) }
}