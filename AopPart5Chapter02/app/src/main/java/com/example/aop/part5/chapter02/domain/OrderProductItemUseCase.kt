package com.example.aop.part5.chapter02.domain

import com.example.aop.part5.chapter02.data.entity.product.ProductEntity
import com.example.aop.part5.chapter02.data.repository.ProductRepository

internal class OrderProductItemUseCase(
	private val productRepository: ProductRepository
): UseCase {

	suspend operator fun invoke(productEntity: ProductEntity): Long {
		return productRepository.insertProductItem(productEntity)
	}

}