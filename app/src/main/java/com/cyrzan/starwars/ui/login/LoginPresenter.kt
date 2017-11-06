package com.cyrzan.starwars.ui.login

import com.cyrzan.starwars.data.repository.DribbbleRepository

/**
 * Created by Patryk on 06.11.2017.
 */

class LoginPresenter(private val repository: DribbbleRepository) : LoginContract.Presenter {

    override var view: LoginContract.View? = null

    override fun attachView(view: LoginContract.View) {
        this.view = view
    }

    override fun detachView() {
        view = null
    }

    override fun doLogin() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun handleSuccess() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun handleError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}