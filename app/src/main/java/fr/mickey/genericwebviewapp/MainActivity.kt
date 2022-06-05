package fr.mickey.genericwebviewapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.webkit.WebView
import android.webkit.WebViewClient

import android.widget.ImageView
import mickey.genericwebviewapp.R


class MainActivity : Activity() {
    private lateinit var webView: WebView
    private val switchButton: ImageView by lazy { findViewById(R.id.switchButton) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sharedPref = getSharedPreferences("localstorage", MODE_PRIVATE)
        var url = getString(R.string.my_url);
        val stored = sharedPref.getString("url", "")!!;
        url = if (stored.isNotEmpty()) stored else url;
        if (url.isEmpty()) goSelecting(switchButton);

        webView = findViewById(R.id.webview)
        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String): Boolean {
                view?.loadUrl(url)
                return true
            }
        }
        webView.loadUrl(url)

        switchButton.setOnLongClickListener {
            goSelecting(switchButton);
            true
        }

    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        // Check if the key event was the Back button and if there's history
        if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
            webView.goBack()
            return true
        }
        // If it wasn't the Back key or there's no web page history, bubble up to the default
        // system behavior (probably exit the activity)
        return super.onKeyDown(keyCode, event)
    }


    fun goSelecting(view: android.view.View) {
        Intent(this@MainActivity, SelectUrlActivity::class.java).also {
            startActivity(it)
        }
    }

}