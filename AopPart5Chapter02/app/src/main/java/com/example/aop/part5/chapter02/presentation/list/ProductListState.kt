package com.example.aop.part5.chapter02.presentation.list

import com.example.aop.part5.chapter02.data.entity.product.ProductEntity

sealed class ProductListState {

	object UnInitialized: ProductListState()

	object Loading: ProductListState()

	data class Success(
		val productList: List<ProductEntity>
	): ProductListState()

	object Error: ProductListState()

}
