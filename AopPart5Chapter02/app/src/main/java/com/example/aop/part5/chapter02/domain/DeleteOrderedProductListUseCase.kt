package com.example.aop.part5.chapter02.domain

import com.example.aop.part5.chapter02.data.repository.ProductRepository

internal class DeleteOrderedProductListUseCase(
	private val productRepository: ProductRepository
): UseCase {

	suspend operator fun invoke() {
		return productRepository.deleteAll()
	}

}