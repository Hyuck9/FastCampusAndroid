package com.example.aop.part5.chapter_05.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Station(
    val name: String,
    val isFavored: Boolean,
    val connectedSubways: List<Subway>
) : Parcelable
