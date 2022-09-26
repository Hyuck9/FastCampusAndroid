package com.example.aop.part5.chapter02.di

import com.example.aop.part5.chapter02.data.db.provideDB
import com.example.aop.part5.chapter02.data.db.provideToDoDao
import com.example.aop.part5.chapter02.data.network.buildOkHttpClient
import com.example.aop.part5.chapter02.data.network.provideGsonConverterFactory
import com.example.aop.part5.chapter02.data.network.provideProductApiService
import com.example.aop.part5.chapter02.data.network.provideProductRetrofit
import com.example.aop.part5.chapter02.data.preference.PreferenceManager
import com.example.aop.part5.chapter02.data.repository.DefaultProductRepository
import com.example.aop.part5.chapter02.data.repository.ProductRepository
import com.example.aop.part5.chapter02.domain.GetProductItemUseCase
import com.example.aop.part5.chapter02.domain.GetProductListUseCase
import com.example.aop.part5.chapter02.domain.OrderProductItemUseCase
import com.example.aop.part5.chapter02.presentation.detail.ProductDetailViewModel
import com.example.aop.part5.chapter02.presentation.list.ProductListViewModel
import com.example.aop.part5.chapter02.presentation.main.MainViewModel
import com.example.aop.part5.chapter02.presentation.profile.ProfileViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

	// ViewModels
	viewModel { MainViewModel() }
	viewModel { ProductListViewModel(get()) }
	viewModel { ProfileViewModel(get()) }
	viewModel { (productId: Long) -> ProductDetailViewModel(productId, get(), get()) }

	// Coroutines Dispatcher
	single { Dispatchers.Main }
	single { Dispatchers.IO }

	// UseCases
	factory { GetProductItemUseCase(get()) }
	factory { GetProductListUseCase(get()) }
	factory { OrderProductItemUseCase(get()) }

	// Repositories
	single<ProductRepository> { DefaultProductRepository(get(), get(), get()) }

	// Retrofit
	single { provideGsonConverterFactory() }
	single { buildOkHttpClient() }
	single { provideProductRetrofit(get(), get()) }
	single { provideProductApiService(get()) }

	// Preference
	single { PreferenceManager(androidContext()) }

	// Database
	single { provideDB(androidApplication()) }
	single { provideToDoDao(get()) }

}