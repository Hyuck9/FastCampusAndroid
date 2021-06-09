package com.example.aop.part4.chapter02

import com.example.aop.part4.chapter02.service.MusicEntity

fun MusicEntity.mapper(id: Long): MusicModel =
	MusicModel(
		id = id,
		streamUrl = streamUrl,
		coverUrl = coverUrl,
		track = track,
		artist = artist
	)