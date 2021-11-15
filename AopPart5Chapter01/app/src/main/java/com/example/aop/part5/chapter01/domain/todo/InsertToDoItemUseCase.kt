package com.example.aop.part5.chapter01.domain.todo

import com.example.aop.part5.chapter01.data.entity.ToDoEntity
import com.example.aop.part5.chapter01.data.repository.ToDoRepository
import com.example.aop.part5.chapter01.domain.UseCase

internal class InsertToDoItemUseCase(
	private val toDoRepository: ToDoRepository
): UseCase {

	suspend operator fun invoke(toDoItem: ToDoEntity) {
		return toDoRepository.insertToDoItem(toDoItem)
	}

}