package com.example.part3_chapter06.home

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.part3_chapter06.DBKey.Companion.DB_ARTICLES
import com.example.part3_chapter06.R
import com.example.part3_chapter06.databinding.FragmentHomeBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class HomeFragment : Fragment(R.layout.fragment_home) {

	private lateinit var articleAdapter: ArticleAdapter
	private lateinit var articleDB: DatabaseReference
	private lateinit var binding: FragmentHomeBinding

	private val articleList = mutableListOf<ArticleModel>()
	private val listener = object : ChildEventListener {
		override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
			val articleModel = snapshot.getValue(ArticleModel::class.java)
			articleModel ?: return
			articleList.add(articleModel)
			articleAdapter.submitList(articleList)
		}
		override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {}
		override fun onChildRemoved(snapshot: DataSnapshot) {}
		override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {}
		override fun onCancelled(error: DatabaseError) {}
	}
	private val auth: FirebaseAuth by lazy { Firebase.auth }

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		binding = FragmentHomeBinding.bind(view)

		articleList.clear()
		articleDB = Firebase.database.reference.child(DB_ARTICLES)
		articleAdapter = ArticleAdapter()

		binding.articleRecyclerView.layoutManager = LinearLayoutManager(context)
		binding.articleRecyclerView.adapter = articleAdapter
		binding.addFloatingButton.setOnClickListener {
			// TODO: 로그인 기능 구현 후에 주석 지우기
//			if (auth.currentUser != null) {
				startActivity(Intent(requireActivity(), AddArticleActivity::class.java))
//			} else {
//				Snackbar.make(view, "로그인 후 사용해주세요", Snackbar.LENGTH_LONG).show()
//			}
		}

		articleDB.addChildEventListener(listener)

	}

	@SuppressLint("NotifyDataSetChanged")
	override fun onResume() {
		super.onResume()
		articleAdapter.notifyDataSetChanged()
	}
	override fun onDestroy() {
		super.onDestroy()
		articleDB.removeEventListener(listener)
	}
}