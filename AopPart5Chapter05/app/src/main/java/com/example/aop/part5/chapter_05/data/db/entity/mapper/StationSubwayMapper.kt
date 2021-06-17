package com.example.aop.part5.chapter_05.data.db.entity.mapper

import com.example.aop.part5.chapter_05.data.db.entity.StationWithSubwaysEntity
import com.example.aop.part5.chapter_05.data.db.entity.SubwayEntity
import com.example.aop.part5.chapter_05.domain.Station
import com.example.aop.part5.chapter_05.domain.Subway

fun StationWithSubwaysEntity.toStation() = Station(
	name = station.stationName,
	isFavored = station.isFavored,
	connectedSubways = subways.toSubways()
)

fun List<StationWithSubwaysEntity>.toStations() = map { it.toStation() }

fun List<SubwayEntity>.toSubways(): List<Subway> = map { Subway.findById(it.subwayId) }