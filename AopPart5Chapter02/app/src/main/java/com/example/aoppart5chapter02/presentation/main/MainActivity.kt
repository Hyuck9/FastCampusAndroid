package com.example.aoppart5chapter02.presentation.main

import android.os.Bundle
import android.os.PersistableBundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.aoppart5chapter02.R
import com.example.aoppart5chapter02.databinding.ActivityMainBinding
import com.example.aoppart5chapter02.presentation.BaseActivity
import com.example.aoppart5chapter02.presentation.list.ProductListFragment
import com.example.aoppart5chapter02.presentation.profile.ProfileFragment
import com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener
import org.koin.android.ext.android.inject

internal class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {

	override val viewModel by inject<MainViewModel>()

	override fun getViewBinding(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)

	override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
		super.onCreate(savedInstanceState, persistentState)
		initViews()
	}

	private fun initViews() = with(binding) {
		bottomNav.setOnItemSelectedListener {
			when(it.itemId) {
				R.id.menu_products -> {
					showFragment(ProductListFragment(), ProductListFragment.TAG)
					true
				}
				R.id.menu_profile -> {
					showFragment(ProfileFragment(), ProfileFragment.TAG)
					true
				}
				else -> {
					false
				}
			}
		}
		showFragment(ProductListFragment(), ProductListFragment.TAG)
	}

	private fun showFragment(fragment: Fragment, tag: String) {
		val findFragment = supportFragmentManager.findFragmentByTag(tag)
		supportFragmentManager.fragments.forEach { fm ->
			supportFragmentManager.beginTransaction().hide(fm).commit()
		}
		findFragment?.let {
			supportFragmentManager.beginTransaction().show(it).commit()
		} ?: kotlin.run {
			supportFragmentManager.beginTransaction()
				.add(R.id.fragmentContainer, fragment, tag)
				.commitAllowingStateLoss()
		}
	}

	override fun observeData() {
	}

}