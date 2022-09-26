package com.example.aop.part5.chapter02.presentation.list

import com.example.aop.part5.chapter02.databinding.FragmentProductListBinding
import com.example.aop.part5.chapter02.presentation.base.BaseFragment
import org.koin.android.ext.android.inject

internal class ProductListFragment: BaseFragment<ProductListViewModel, FragmentProductListBinding>() {

	override val viewModel by inject<ProductListViewModel>()

	override fun getViewBinding(): FragmentProductListBinding = FragmentProductListBinding.inflate(layoutInflater)

	override fun observeData() {
	}

	companion object {
		const val TAG = "ProductListFragment"
	}
}