package com.example.part3_chapter06.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.part3_chapter06.R
import com.example.part3_chapter06.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {

	private lateinit var binding: FragmentHomeBinding
	private lateinit var articleAdapter: ArticleAdapter

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		binding = FragmentHomeBinding.bind(view)

		articleAdapter = ArticleAdapter()

		binding.articleRecyclerView.layoutManager = LinearLayoutManager(context)
		binding.articleRecyclerView.adapter = articleAdapter

	}
}