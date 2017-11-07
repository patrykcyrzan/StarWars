package com.cyrzan.starwars.ui.login

import com.cyrzan.starwars.data.repository.DribbbleRepository
import javax.inject.Inject

/**
 * Created by Patryk on 06.11.2017.
 */

class LoginPresenter @Inject constructor(private val repository: DribbbleRepository) : LoginContract.Presenter {

    override var view: LoginContract.View? = null

    override fun attachView(view: LoginContract.View) {
        this.view = view
    }

    override fun detachView() {
        view = null
    }

    override fun doLogin() {
        view?.showLoading()
        view?.showWebView()
    }

    override fun handleSuccess() {
        //view?.hideLoading()
    }

    override fun handleError() {
        //view?.hideLoading()
    }
}