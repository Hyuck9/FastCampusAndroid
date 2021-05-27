package com.example.part2chapter08

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.EditText

class MainActivity : AppCompatActivity() {

	private val addressBar: EditText by lazy { findViewById(R.id.addressBar) }
	private val webView: WebView by lazy { findViewById(R.id.webView) }

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		initViews()
		bindViews()
	}

	@SuppressLint("SetJavaScriptEnabled")
	private fun initViews() {
		webView.apply {
			webViewClient = WebViewClient()		// default web browser 가 아닌 앱 내부의 webView 를 사용하기 위해 webViewClient 설정
			settings.javaScriptEnabled = true	// javaScript 허용 (XSS 보안 관련 이슈 있지만 여기선 일단 무시)
			loadUrl("http://www.google.com")
		}
	}

	private fun bindViews() {
		addressBar.setOnEditorActionListener { v, actionId, event -> 
			if (actionId == EditorInfo.IME_ACTION_DONE) {
				webView.loadUrl(v.text.toString())
			}
			
			return@setOnEditorActionListener false	// 이벤트를 소비했으니 다른쪽에서 핸들링하지 않아도 된다는 의미로 false 반환
		}
	}
}