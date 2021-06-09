package com.example.aop.part4.chapter02

import com.example.aop.part4.chapter02.service.MusicDto
import com.example.aop.part4.chapter02.service.MusicEntity

fun MusicEntity.mapper(id: Long): MusicModel =
	MusicModel(
		id = id,
		streamUrl = streamUrl,
		coverUrl = coverUrl,
		track = track,
		artist = artist
	)

fun MusicDto.mapper(): PlayerModel =
	PlayerModel(
		playMusicList = musics.mapIndexed { index, musicEntity ->
			musicEntity.mapper(index.toLong())
		}

	)