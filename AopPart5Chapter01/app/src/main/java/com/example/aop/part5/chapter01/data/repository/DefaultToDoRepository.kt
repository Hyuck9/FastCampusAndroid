package com.example.aop.part5.chapter01.data.repository

import com.example.aop.part5.chapter01.data.entity.ToDoEntity

class DefaultToDoRepository: ToDoRepository {
	override suspend fun getToDoList(): List<ToDoEntity> {
		TODO("Not yet implemented")
	}

	override suspend fun insertToDoList(toDoList: List<ToDoEntity>) {
		TODO("Not yet implemented")
	}

	override suspend fun updateToDoItem(toDoItem: ToDoEntity): Boolean {
		TODO("Not yet implemented")
	}
}