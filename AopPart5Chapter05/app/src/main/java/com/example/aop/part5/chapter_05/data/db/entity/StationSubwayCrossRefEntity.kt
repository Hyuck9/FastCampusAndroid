package com.example.aop.part5.chapter_05.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(primaryKeys = ["stationName", "subwayId"])
data class StationSubwayCrossRefEntity(
	val stationName: String,
	val subwayId: Int
)
