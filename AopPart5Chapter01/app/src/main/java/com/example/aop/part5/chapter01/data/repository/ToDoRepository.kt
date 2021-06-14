package com.example.aop.part5.chapter01.data.repository

import com.example.aop.part5.chapter01.data.entity.ToDoEntity

/**
 * 1. insertToDoList
 * 2. getToDoList
 * 3. updateToDoItem
 *
 */
interface ToDoRepository {

	suspend fun getToDoList(): List<ToDoEntity>

	suspend fun insertToDoList(toDoList: List<ToDoEntity>)

	suspend fun updateToDoItem(toDoItem: ToDoEntity):Boolean

}