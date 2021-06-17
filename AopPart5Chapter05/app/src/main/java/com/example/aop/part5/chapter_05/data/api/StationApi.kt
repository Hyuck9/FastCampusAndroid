package com.example.aop.part5.chapter_05.data.api

import com.example.aop.part5.chapter_05.data.db.entity.StationEntity
import com.example.aop.part5.chapter_05.data.db.entity.SubwayEntity

interface StationApi {

	suspend fun getStationDataUpdatedTimeMillis(): Long

	suspend fun getStationSubways(): List<Pair<StationEntity, SubwayEntity>>

}