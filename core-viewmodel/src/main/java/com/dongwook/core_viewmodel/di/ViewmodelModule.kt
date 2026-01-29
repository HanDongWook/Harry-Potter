package com.handongwook.harry_potter.viewmodel.di

import com.handongwook.harry_potter.viewmodel.BaseViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewmodelModule = module {
    viewModel { BaseViewModel(get()) }
}