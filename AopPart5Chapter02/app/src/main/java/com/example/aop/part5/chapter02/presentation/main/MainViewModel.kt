package com.example.aop.part5.chapter02.presentation.main

import androidx.lifecycle.viewModelScope
import com.example.aop.part5.chapter02.presentation.base.BaseViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

internal class MainViewModel: BaseViewModel() {

	override fun fetchData(): Job = viewModelScope.launch {

	}

}