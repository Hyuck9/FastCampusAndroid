package com.example.aop.part5.chapter02.data.repository

import com.example.aop.part5.chapter02.data.entity.product.ProductEntity


interface ProductRepository {

	suspend fun getProductList(): List<ProductEntity>

	suspend fun getLocalProductList(): List<ProductEntity>

	suspend fun insertProductItem(productItem: ProductEntity): Long

	suspend fun insertProductList(productList: List<ProductEntity>)

	suspend fun updateProductItem(productItem: ProductEntity)

	suspend fun getProductItem(itemId: Long): ProductEntity?

	suspend fun deleteAll()

	suspend fun deleteProductItem(id: Long)

}