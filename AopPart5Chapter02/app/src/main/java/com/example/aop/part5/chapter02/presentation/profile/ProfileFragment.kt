package com.example.aop.part5.chapter02.presentation.profile

import com.example.aop.part5.chapter02.databinding.FragmentProfileBinding
import com.example.aop.part5.chapter02.presentation.base.BaseFragment
import org.koin.android.ext.android.inject

internal class ProfileFragment: BaseFragment<ProfileViewModel, FragmentProfileBinding>() {

	override val viewModel by inject<ProfileViewModel>()

	override fun getViewBinding(): FragmentProfileBinding = FragmentProfileBinding.inflate(layoutInflater)

	override fun observeData() {
	}

	companion object {
		const val TAG = "ProfileFragment"
	}
}