package com.example.aop.part5.chapter_05.presentation.stations

import com.example.aop.part5.chapter_05.domain.Station
import com.example.aop.part5.chapter_05.presentation.BasePresenter
import com.example.aop.part5.chapter_05.presentation.BaseView

interface StationsContract {

	interface View : BaseView<Presenter> {

		fun showLoadingIndicator()

		fun hideLoadingIndicator()

		fun showStations(stations: List<Station>)
	}

	interface Presenter : BasePresenter {
		fun filterStations(query: String)
	}
}