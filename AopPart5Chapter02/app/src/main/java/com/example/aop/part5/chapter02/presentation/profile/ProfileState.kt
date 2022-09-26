package com.example.aop.part5.chapter02.presentation.profile

import android.net.Uri
import com.example.aop.part5.chapter02.data.entity.product.ProductEntity

sealed class ProfileState {

	object UnInitialized: ProfileState()

	object Loading: ProfileState()

	data class Login(
		val idToken: String
	): ProfileState()

	sealed class Success: ProfileState() {

		data class Registered(
			val userName: String,
			val profileImageUri: Uri?,
			val productList: List<ProductEntity> = listOf()
		): Success()
		object NotRegistered: Success()
	}

	object Error: ProfileState()

}
