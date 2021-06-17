package com.example.aop.part5.chapter_05.data.preference

interface PreferenceManager {

	fun getLong(key: String): Long?

	fun putLong(key: String, value: Long)

}