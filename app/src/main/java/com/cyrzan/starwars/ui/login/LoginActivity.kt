package com.cyrzan.starwars.ui.login

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.cyrzan.starwars.R
import com.cyrzan.starwars.StarWarsApplication
import com.cyrzan.starwars.databinding.ActivityLoginBinding
import com.cyrzan.starwars.di.module.ActivityModule
import com.cyrzan.starwars.ui.base.BaseActivity
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import com.cyrzan.starwars.BR
import javax.inject.Inject




class LoginActivity : BaseActivity(), LoginContract.View {

    @Inject
    lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel: LoginViewModel = LoginViewModel(false)
        val viewDataBinding: ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        viewDataBinding.setVariable(BR.viewModel, viewModel)
        viewDataBinding.setVariable(BR.presenter, presenter)
    }

    override fun inject() {
        StarWarsApplication.graph.activityComponent(ActivityModule(this)).inject(this)
    }

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loginSuccess() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loginFailure() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
