package com.dongwook.core_viewmodel.di

import com.dongwook.core_viewmodel.BaseViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewmodelModule = module {
    viewModel { BaseViewModel(get()) }
}