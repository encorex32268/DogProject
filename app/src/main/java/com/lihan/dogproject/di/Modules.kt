package com.lihan.dogproject.di

import com.lihan.dogproject.core.data.HttpClientFactory
import com.lihan.dogproject.home_list.data.DogRepositoryImpl
import com.lihan.dogproject.home_list.data.network.KtorRemoteDogDataSource
import com.lihan.dogproject.home_list.data.network.RemoteDogDataSource
import com.lihan.dogproject.home_list.domain.DogRepository
import com.lihan.dogproject.home_list.presentation.DogViewModel
import io.ktor.client.HttpClient
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val appModules = module {
    single{
        HttpClientFactory.build()
    }.bind<HttpClient>()

    single{
        KtorRemoteDogDataSource(
            get()
        )
    }.bind<RemoteDogDataSource>()

    singleOf(::DogRepositoryImpl).bind<DogRepository>()

    viewModelOf(::DogViewModel)

}