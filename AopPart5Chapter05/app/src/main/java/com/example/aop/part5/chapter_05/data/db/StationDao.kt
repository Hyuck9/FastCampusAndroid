package com.example.aop.part5.chapter_05.data.db

import androidx.room.*
import com.example.aop.part5.chapter_05.data.db.entity.StationEntity
import com.example.aop.part5.chapter_05.data.db.entity.StationSubwayCrossRefEntity
import com.example.aop.part5.chapter_05.data.db.entity.StationWithSubwaysEntity
import com.example.aop.part5.chapter_05.data.db.entity.SubwayEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface StationDao {

	@Transaction
	@Query("SELECT * FROM StationEntity")
	fun getStationWithSubways(): Flow<List<StationWithSubwaysEntity>>

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	suspend fun insertStations(station: List<StationEntity>)

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	suspend fun insertSubways(subways: List<SubwayEntity>)

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	suspend fun insertCrossReferences(reference: List<StationSubwayCrossRefEntity>)

}