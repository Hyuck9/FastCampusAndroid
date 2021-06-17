package com.example.aop.part5.chapter_05.data.repository

import com.example.aop.part5.chapter_05.domain.Station
import kotlinx.coroutines.flow.Flow

interface StationRepository {

	val stations: Flow<List<Station>>

	suspend fun refreshStations()

}