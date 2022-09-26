package com.example.aop.part5.chapter02.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.aop.part5.chapter02.data.db.dao.ProductDao
import com.example.aop.part5.chapter02.data.entity.product.ProductEntity
import com.example.aop.part5.chapter02.utils.DateConverter

@Database(
	entities = [ProductEntity::class],
	version = 1,
	exportSchema = false
)
@TypeConverters(DateConverter::class)
abstract class ProductDatabase: RoomDatabase() {

	abstract fun productDao(): ProductDao

	companion object {
		const val DB_NAME = "ProductDataBase.db"
	}
}