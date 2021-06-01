package com.example.part3_chapter07

import retrofit2.Call
import retrofit2.http.GET

interface HouseService {

	@GET("/v3/fc74b3c1-f92d-4ac3-9d49-c80eeaef7dcb")
	fun getHouseList(): Call<HouseDto>
}