package com.example.aop.part5.chapter02.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.aop.part5.chapter02.domain.GetProductListUseCase
import com.example.aop.part5.chapter02.presentation.base.BaseViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

internal class ProductListViewModel(
	private val getProductListUseCase: GetProductListUseCase
): BaseViewModel() {

	private val _productListStateLiveData = MutableLiveData<ProductListState>(ProductListState.UnInitialized)
	val productListStateLiveData: LiveData<ProductListState> = _productListStateLiveData

	override fun fetchData(): Job = viewModelScope.launch {
		setState(
			ProductListState.Loading
		)
		setState(
			ProductListState.Success(
				getProductListUseCase()
			)
		)
	}

	private fun setState(state: ProductListState) {
		_productListStateLiveData.postValue(state)
	}

}