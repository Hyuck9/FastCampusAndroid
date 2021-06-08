package com.example.aop.part4.chapter01.service

import com.example.aop.part4.chapter01.dto.VideoDto
import retrofit2.Call
import retrofit2.http.GET

interface VideoService {

	@GET("/v3/b01c5dd8-9748-4a62-a54f-3461063227bf")
	fun listVidoes(): Call<VideoDto>
}