package com.cyrzan.starwars.ui.login

import android.net.Uri
import android.util.Log
import com.cyrzan.starwars.data.repository.DribbbleRepository
import com.cyrzan.starwars.model.LoginResponse
import com.cyrzan.starwars.util.Constants
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
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
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {handleAccessToken(it)},
                        { Log.i("Loginpresenter", "brak tokena")}
                )
    }

    private fun handleAccessToken(response: LoginResponse){
        Log.i("LoginPresenter", "token ${response.token}")
    }
}