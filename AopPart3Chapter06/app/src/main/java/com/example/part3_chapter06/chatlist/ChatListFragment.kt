package com.example.part3_chapter06.chatlist

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.part3_chapter06.DBKey.Companion.CHILD_CHAT
import com.example.part3_chapter06.DBKey.Companion.DB_USERS
import com.example.part3_chapter06.R
import com.example.part3_chapter06.databinding.FragmentChatlistBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class ChatListFragment : Fragment(R.layout.fragment_chatlist) {

	private lateinit var binding: FragmentChatlistBinding
	private lateinit var chatListAdapter: ChatListAdapter
	private lateinit var chatDB: DatabaseReference

	private val chatRoomList = mutableListOf<ChatListItem>()
	private val auth: FirebaseAuth by lazy { Firebase.auth }

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		binding = FragmentChatlistBinding.bind(view)

		chatListAdapter = ChatListAdapter(onItemClicked = {
			// 채팅방으로 이동하는 코드
		})

		chatRoomList.clear()

		binding.chatListRecyclerView.adapter = chatListAdapter
		binding.chatListRecyclerView.layoutManager = LinearLayoutManager(context)

		if (auth.currentUser == null) {
			return
		}

		chatDB = Firebase.database.reference.child(DB_USERS).child(auth.currentUser!!.uid).child((CHILD_CHAT))

		chatDB.addListenerForSingleValueEvent(object : ValueEventListener {
			@SuppressLint("NotifyDataSetChanged")
			override fun onDataChange(snapshot: DataSnapshot) {
				snapshot.children.forEach {
					val model = it.getValue(ChatListItem::class.java)
					model ?: return

					chatRoomList.add(model)
				}

				chatListAdapter.submitList(chatRoomList)
				chatListAdapter.notifyDataSetChanged()
			}

			override fun onCancelled(error: DatabaseError) {
			}

		})


	}

	@SuppressLint("NotifyDataSetChanged")
	override fun onResume() {
		super.onResume()
		chatListAdapter.notifyDataSetChanged()
	}
}