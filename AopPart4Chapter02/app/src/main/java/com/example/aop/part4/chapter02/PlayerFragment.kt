package com.example.aop.part4.chapter02

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.aop.part4.chapter02.databinding.FragmentPlayerBinding
import com.example.aop.part4.chapter02.service.MusicDto
import com.example.aop.part4.chapter02.service.MusicService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PlayerFragment : Fragment(R.layout.fragment_player) {

	private lateinit var binding: FragmentPlayerBinding
	private var isWatchingPlayListView = true

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		binding = FragmentPlayerBinding.bind(view)

		initPlayListButton()

		getVideoListFromServer()
	}

	private fun initPlayListButton() {
		binding.playlistImageView.setOnClickListener {
			// TODO: 서버에서 데이터가 다 불려오지 않은 상태일 때 예외처리
			binding.playerViewGroup.isVisible = isWatchingPlayListView
			binding.playListViewGroup.isVisible = isWatchingPlayListView.not()

			isWatchingPlayListView = !isWatchingPlayListView
		}
	}

	private fun getVideoListFromServer() {
		val retrofit = Retrofit.Builder()
			.baseUrl("https://run.mocky.io")
			.addConverterFactory(GsonConverterFactory.create())
			.build()

		retrofit.create(MusicService::class.java).also {
			it.listMusics()
				.enqueue(object: Callback<MusicDto> {
					override fun onResponse(call: Call<MusicDto>, response: Response<MusicDto>) {
						Log.d("PlayerFragment", "${response.body()}")

						response.body()?.let { musicDto ->

							val modelList = musicDto.musics.mapIndexed { index, musicEntity ->
								musicEntity.mapper(index.toLong())
							}



						}
					}

					override fun onFailure(call: Call<MusicDto>, t: Throwable) {
					}
				})
		}
	}

	companion object {
		fun newInstance(): PlayerFragment = PlayerFragment()
	}

}