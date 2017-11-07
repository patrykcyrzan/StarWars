package com.cyrzan.starwars.ui.login

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import com.cyrzan.starwars.R
import com.cyrzan.starwars.StarWarsApplication
import com.cyrzan.starwars.databinding.ActivityLoginBinding
import com.cyrzan.starwars.di.module.ActivityModule
import com.cyrzan.starwars.ui.base.BaseActivity
import com.cyrzan.starwars.util.Constants
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject


class LoginActivity : BaseActivity(), LoginContract.View {

    @Inject
    lateinit var presenter: LoginPresenter

    private lateinit var viewDataBinding: ActivityLoginBinding
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = LoginViewModel()
        viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        viewDataBinding.viewModel = viewModel
        viewDataBinding.presenter = presenter

        setupWebView()
    }

    override fun onResume() {
        super.onResume()
        presenter.attachView(this)
    }

    override fun inject() {
        StarWarsApplication.graph.activityComponent(ActivityModule(this)).inject(this)
    }

    override fun showLoading() {
        viewModel.isLoading = true
    }

    override fun hideLoading() {
        viewModel.isLoading = false
    }

    override fun loginSuccess() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loginFailure() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showWebView() {
        viewModel.isWebViewVisible = true

        webView.loadUrl(Constants.AUTH_URL)
    }

    private fun setupWebView() {
        webView.apply {
            webViewClient = object : WebViewClient() {

                override fun onPageFinished(view: WebView, url: String) {
                    hideLoading()
                }
            }
        }
    }
}
