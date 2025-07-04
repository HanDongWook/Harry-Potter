package com.handongwook.harry_potter.feature.details.di

import com.dongwook.core_viewmodel.di.viewmodelModule
import com.handongwook.core_data.NetworkCoroutineExceptionHandler
import com.handongwook.core_data.di.dataModule
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val detailsModule = module {
    includes(dataModule)
    includes(viewmodelModule)

    viewModel { DetailsViewModel(get<NetworkCoroutineExceptionHandler>()) }
}