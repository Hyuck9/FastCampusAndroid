package com.example.aop.part5.chapter02.presentation.detail

import com.example.aop.part5.chapter02.data.entity.product.ProductEntity

sealed class ProductDetailState {

	object UnInitialized: ProductDetailState()

	object Loading: ProductDetailState()

	data class Success(
		val productEntity: ProductEntity
	): ProductDetailState()

	object Order: ProductDetailState()

	object Error: ProductDetailState()

}
