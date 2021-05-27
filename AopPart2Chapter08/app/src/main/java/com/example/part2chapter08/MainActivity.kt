package com.example.part2chapter08

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.EditText
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {

	private val goHomeButton: ImageButton by lazy { findViewById(R.id.goHomeButton) }
	private val addressBar: EditText by lazy { findViewById(R.id.addressBar) }
	private val goBackButton: ImageButton by lazy { findViewById(R.id.goBackButton) }
	private val goForwardButton: ImageButton by lazy { findViewById(R.id.goForwardButton) }
	private val webView: WebView by lazy { findViewById(R.id.webView) }

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		initViews()
		bindViews()
	}

	override fun onBackPressed() {
		if (webView.canGoBack()) {
			webView.goBack()
		} else {
			super.onBackPressed()
		}
	}

	@SuppressLint("SetJavaScriptEnabled")
	private fun initViews() {
		webView.apply {
			webViewClient = WebViewClient()		// default web browser 가 아닌 앱 내부의 webView 를 사용하기 위해 webViewClient 설정
			settings.javaScriptEnabled = true	// javaScript 허용 (XSS 보안 관련 이슈 있지만 여기선 일단 무시)
			loadUrl(DEFAULT_URL)
		}
	}

	private fun bindViews() {
		goHomeButton.setOnClickListener {
			webView.loadUrl(DEFAULT_URL)
		}

		addressBar.setOnEditorActionListener { v, actionId, event -> 
			if (actionId == EditorInfo.IME_ACTION_DONE) {
				webView.loadUrl(v.text.toString())
			}
			return@setOnEditorActionListener false	// 이벤트를 소비했으니 다른쪽에서 핸들링하지 않아도 된다는 의미로 false 반환
		}

		goBackButton.setOnClickListener {
			webView.goBack()
		}

		goForwardButton.setOnClickListener {
			webView.goForward()
		}
	}

	companion object {
		private const val  DEFAULT_URL = "http://www.google.com"
	}
}