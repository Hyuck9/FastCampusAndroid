package com.example.aop.part5.chapter02

import android.app.Application
import com.example.aop.part5.chapter02.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class AopPart5Chapter02Application: Application() {

	override fun onCreate() {
		super.onCreate()

		startKoin {
			androidLogger(Level.ERROR)
			androidContext(this@AopPart5Chapter02Application)
			modules(appModule)
		}
	}

}