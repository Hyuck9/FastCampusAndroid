package com.example.aop.part5.chapter01.domain.todo

import com.example.aop.part5.chapter01.data.repository.ToDoRepository
import com.example.aop.part5.chapter01.domain.UseCase

internal class DeleteToDoItemUseCase(
	private val toDoRepository: ToDoRepository
): UseCase {

	suspend operator fun invoke(itemId: Long): Boolean {
		return toDoRepository.deleteToDoItem(itemId)
	}

}