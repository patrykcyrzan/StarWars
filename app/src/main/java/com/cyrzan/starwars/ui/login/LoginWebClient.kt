package com.cyrzan.starwars.ui.login

import android.os.Build
import android.support.annotation.RequiresApi
import android.util.Log
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient

/**
 * Created by Patryk on 07.11.2017.
 */

typealias Callback = (url : String?) -> Unit

open class LoginWebClient(private val callback: Callback) : WebViewClient() {
    @Suppress("OverridingDeprecatedMember")
    override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
        url?.let { callback.invoke(it) }
        return false
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
        request?.let {
            callback.invoke(it.url.toString())
        }
        return false
    }

    override fun onPageFinished(view: WebView?, url: String?) {
        super.onPageFinished(view, url)
        callback.invoke(null)
    }
}