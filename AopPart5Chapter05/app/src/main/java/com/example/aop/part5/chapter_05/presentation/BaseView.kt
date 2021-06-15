package com.example.aop.part5.chapter_05.presentation

interface BaseView<PresenterT : BasePresenter> {

	val presenter: PresenterT
}