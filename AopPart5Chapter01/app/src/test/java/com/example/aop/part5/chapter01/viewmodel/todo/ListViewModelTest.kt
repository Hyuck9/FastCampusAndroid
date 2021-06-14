package com.example.aop.part5.chapter01.viewmodel.todo

import com.example.aop.part5.chapter01.data.entity.ToDoEntity
import com.example.aop.part5.chapter01.domain.todo.InsertToDoListUseCase
import com.example.aop.part5.chapter01.presentation.list.ListViewModel
import com.example.aop.part5.chapter01.viewmodel.ViewModelTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.koin.test.inject

/**
 * [ListViewModel] 을 테스트하기 위한 Unit TestClass
 *
 * 1. initData()
 * 2. test viewModel fetch
 * 3. test Item Update
 * 4. test Item Delete All
 *
 */
@ExperimentalCoroutinesApi
internal class ListViewModelTest: ViewModelTest() {

	private val viewModel: ListViewModel by inject()

	private val insertToDoListUseCase: InsertToDoListUseCase by inject()

	private val mockList = (0 until 10).map {
		ToDoEntity(
			id = it.toLong(),
			title = "title $it",
			description = "description $it",
			hasCompleted = false
		)
	}

	/*
	 * 필요한 UseCase 들
	 * 1. InsertTodoListUseCase
	 * 2. GetToDoItemUseCase
	 */

	@Before
	fun init() {
		initData()
	}

	private fun initData() = runBlockingTest {
		insertToDoListUseCase(mockList)
	}

	// Test : 입력된 데이터를 불러와서 검증한다.
	@Test
	fun `test viewModel fetch`(): Unit = runBlockingTest {
		val testObservable = viewModel.toDoListLiveData.test()
		viewModel.fetchData()
		testObservable.assertValueSequence(
			listOf(
				mockList
			)
		)
	}

	// Test : 데이터를 업데이트 했을 때 잘 반영되는가
	@Test
	fun `test Item Update`(): Unit = runBlockingTest {
		val todo = ToDoEntity(
			id = 1,
			title = "title 1",
			description = "description 1",
			hasCompleted = true
		)
		viewModel.updateEntity(todo)
	}
}