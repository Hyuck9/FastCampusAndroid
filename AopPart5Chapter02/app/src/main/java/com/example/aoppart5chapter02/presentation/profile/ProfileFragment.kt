package com.example.aoppart5chapter02.presentation.profile

import com.example.aoppart5chapter02.databinding.FragmentProfileBinding
import com.example.aoppart5chapter02.presentation.BaseFragment
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