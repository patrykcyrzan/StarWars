package com.cyrzan.starwars.ui.login

import android.net.Uri
import com.cyrzan.starwars.data.repository.DribbbleRepository
import com.cyrzan.starwars.model.LoginResponse
import com.cyrzan.starwars.util.Constants
import com.cyrzan.starwars.util.SchedulerProvider
import javax.inject.Inject


/**
 * Created by Patryk on 06.11.2017.
 */

class LoginPresenter @Inject constructor(private val repository: DribbbleRepository, private val schedulerProvider: SchedulerProvider) : LoginContract.Presenter {

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

    override fun handleUrl(url: String?) {
        view?.hideLoading()
        if (url == null) return

        val code = getCodeParamFromUrl(url)

        if (code != null) {
            onLoginSuccess(code)
        } else {
            view?.loginFailure()
        }
    }

    private fun getCodeParamFromUrl(url: String): String? {
        val uri = Uri.parse(url)
        return uri.getQueryParameter(Constants.CODE_PARAM)
    }

    private fun onLoginSuccess(code: String) {
        view?.showLoading()
        repository.loginUser(code)
                .subscribeOn(schedulerProvider.ioScheduler())
                .observeOn(schedulerProvider.uiScheduler())
                .subscribe(
                        { handleAccessToken(it) },
                        { handleErrorAccessToken(it) }
                )
    }

    private fun handleAccessToken(response: LoginResponse) {
        repository.saveUserToken(response.token)
        view?.loginSuccess()
    }

    private fun handleErrorAccessToken(t: Throwable) {
        view?.loginFailure()
    }
}