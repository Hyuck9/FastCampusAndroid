package com.example.aop.part5.chapter01.di

import com.example.aop.part5.chapter01.data.repository.TestToDoRepository
import com.example.aop.part5.chapter01.data.repository.ToDoRepository
import com.example.aop.part5.chapter01.domain.todo.GetToDoListUseCase
import com.example.aop.part5.chapter01.domain.todo.InsertToDoListUseCase
import com.example.aop.part5.chapter01.domain.todo.UpdateToDoUseCase
import com.example.aop.part5.chapter01.presentation.list.ListViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val appTestModule = module {

	// ViewModel
	viewModel { ListViewModel(get(), get()) }

	// UseCase
	factory { GetToDoListUseCase(get()) }
	factory { InsertToDoListUseCase(get()) }
	factory { UpdateToDoUseCase(get()) }

	// Repository
	single<ToDoRepository> { TestToDoRepository() }

}