package com.example.aoppart5chapter02.data.response

data class ProductsResponse(
	val items: List<ProductResponse>,
	val count: Int
)