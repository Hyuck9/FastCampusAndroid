package com.example.aop.part5.chapter_05.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aop.part5.chapter_05.R
import com.example.aop.part5.chapter_05.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

	val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(binding.root)
	}
}