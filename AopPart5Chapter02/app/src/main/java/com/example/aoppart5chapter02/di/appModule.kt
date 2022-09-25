package com.example.aoppart5chapter02.di

import com.example.aoppart5chapter02.data.network.buildOkHttpClient
import com.example.aoppart5chapter02.data.network.provideGsonConverterFactory
import com.example.aoppart5chapter02.data.network.provideProductApiService
import com.example.aoppart5chapter02.data.network.provideProductRetrofit
import com.example.aoppart5chapter02.data.repository.DefaultProductRepository
import com.example.aoppart5chapter02.data.repository.ProductRepository
import com.example.aoppart5chapter02.domain.GetProductItemUseCase
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val appModule = module {

	// Coroutines Dispatcher
	single { Dispatchers.Main }
	single { Dispatchers.IO }

	// UseCases
	factory { GetProductItemUseCase(get()) }

	// Repositories
	single<ProductRepository> { DefaultProductRepository(get(), get()) }

	// Retrofit
	single { provideGsonConverterFactory() }
	single { buildOkHttpClient() }
	single { provideProductRetrofit(get(), get()) }
	single { provideProductApiService(get()) }

}