package com.example.aop.part5.chapter02.extensions

import android.content.res.Resources

internal fun Float.fromDpToPx(): Int {
	return (this * Resources.getSystem().displayMetrics.density).toInt()
}