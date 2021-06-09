package com.example.aop.part4.chapter02

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aop.part4.chapter02.databinding.FragmentPlayerBinding
import com.example.aop.part4.chapter02.service.MusicDto
import com.example.aop.part4.chapter02.service.MusicService
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.SimpleExoPlayer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PlayerFragment : Fragment(R.layout.fragment_player) {

	private lateinit var binding: FragmentPlayerBinding
	private var isWatchingPlayListView = true
	private var player: SimpleExoPlayer? = null
	private lateinit var playListAdapter: PlayListAdapter

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		binding = FragmentPlayerBinding.bind(view)

		initPlayView()
		initPlayListButton()
		initPlayControlButtons()
		initRecyclerView()

		getVideoListFromServer()
	}

	private fun initPlayControlButtons() {
		binding.playControlImageView.setOnClickListener {
			val player = this.player ?: return@setOnClickListener

			if (player.isPlaying) {
				player.pause()
			} else {
				player.play()
			}
		}
		binding.skipNextImageView.setOnClickListener {

		}
		binding.skipPrevImageView.setOnClickListener {

		}
	}

	private fun initPlayView() {
		context?.let {
			player = SimpleExoPlayer.Builder(it).build()
		}
		binding.apply {
			playerView.player = player
			player?.addListener(object : Player.EventListener {
				override fun onIsPlayingChanged(isPlaying: Boolean) {
					super.onIsPlayingChanged(isPlaying)

					if (isPlaying) {
						playControlImageView.setImageResource(R.drawable.ic_baseline_pause_48)
					} else {
						playControlImageView.setImageResource(R.drawable.ic_baseline_play_arrow_48)
					}
				}
			})
		}
	}

	private fun initRecyclerView() {
		playListAdapter = PlayListAdapter {
			// TODO: 음악 재생
		}

		binding.playListRecyclerView.apply {
			adapter = playListAdapter
			layoutManager = LinearLayoutManager(context)
		}
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
				.enqueue(object : Callback<MusicDto> {
					override fun onResponse(call: Call<MusicDto>, response: Response<MusicDto>) {
						Log.d("PlayerFragment", "${response.body()}")

						response.body()?.let { musicDto ->

							val modelList = musicDto.musics.mapIndexed { index, musicEntity ->
								musicEntity.mapper(index.toLong())
							}

							setMusicList(modelList)
							playListAdapter.submitList(modelList)

						}
					}

					override fun onFailure(call: Call<MusicDto>, t: Throwable) {
					}
				})
		}
	}

	private fun setMusicList(modelList: List<MusicModel>) {
		context?.let {
			player?.addMediaItems(modelList.map { musicModel ->
				MediaItem.Builder()
					.setMediaId(musicModel.id.toString())
					.setUri(musicModel.streamUrl)
					.build()
			})

			player?.prepare()
			player?.play()
		}
	}

	companion object {
		fun newInstance(): PlayerFragment = PlayerFragment()
	}

}