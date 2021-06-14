package com.example.aop.part5.chapter01.data.repository

import com.example.aop.part5.chapter01.data.entity.ToDoEntity

/**
 * 1. InsertToDoList
 * 2. GetToDoList
 *
 */
interface ToDoRepository {

	suspend fun getToDoList(): List<ToDoEntity>

	suspend fun insertToDoList(toDoList: List<ToDoEntity>)

}