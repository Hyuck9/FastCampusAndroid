package com.example.aop.part5.chapter_05.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class StationEntity(
	@PrimaryKey val stationName: String,
	val isFavored: Boolean = false
)
