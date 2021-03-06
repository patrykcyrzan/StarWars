package com.cyrzan.starwars.ui.login

import com.cyrzan.starwars.ui.base.BaseContract

/**
 * Created by Patryk on 06.11.2017.
 */

interface LoginContract {
    interface View : BaseContract.View {
        fun showLoading()
        fun showWebView()
        fun hideLoading()
        fun loginSuccess()
        fun loginFailure()
    }

    interface Presenter : BaseContract.Presenter<View> {
        fun doLogin()
        fun handleUrl(url: String?)
    }
}