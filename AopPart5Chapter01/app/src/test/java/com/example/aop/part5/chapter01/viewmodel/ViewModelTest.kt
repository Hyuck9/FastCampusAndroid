package com.example.aop.part5.chapter01.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.aop.part5.chapter01.di.appTestModule
import com.example.aop.part5.chapter01.livedata.LiveDataTestObserver
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.mockito.Mock
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule

@ExperimentalCoroutinesApi
internal class ViewModelTest: KoinTest {

	@get:Rule
	val mockitoRule: MockitoRule = MockitoJUnit.rule()

	@Mock
	private lateinit var context: Application

	private val dispatcher = TestCoroutineDispatcher()

	@Before
	fun setup() {
		startKoin {
			androidContext(context)
			modules(appTestModule)
		}
		Dispatchers.setMain(dispatcher)
	}

	@After
	fun tearDown() {
		stopKoin()
		Dispatchers.resetMain()	// MainDispatcher 를 초기화 해주어야 메모리 누숙 발생하지 않음.
	}

	protected fun <T> LiveData<T>.test(): LiveDataTestObserver<T> {
		val testObserver = LiveDataTestObserver<T>()
		observeForever(testObserver)
		return testObserver
	}

}