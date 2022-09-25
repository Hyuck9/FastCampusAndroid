package com.example.aoppart5chapter02.presentation.list

import com.example.aoppart5chapter02.databinding.FragmentProductListBinding
import com.example.aoppart5chapter02.presentation.BaseFragment
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