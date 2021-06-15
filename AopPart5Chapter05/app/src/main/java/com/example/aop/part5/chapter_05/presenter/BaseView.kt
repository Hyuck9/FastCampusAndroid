package com.example.aop.part5.chapter_05.presenter

interface BaseView<PresenterT : BasePresenter> {

	val presenter: PresenterT
}