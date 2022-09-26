package com.example.aop.part5.chapter02.domain

import com.example.aop.part5.chapter02.data.entity.product.ProductEntity
import com.example.aop.part5.chapter02.data.repository.ProductRepository

internal class GetProductListUseCase(
	private val productRepository: ProductRepository
): UseCase {

	suspend operator fun invoke(): List<ProductEntity> {
		return productRepository.getProductList()
	}

}