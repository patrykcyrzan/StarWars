package com.cyrzan.starwars.ui.login

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.cyrzan.starwars.R
import com.cyrzan.starwars.StarWarsApplication
import com.cyrzan.starwars.databinding.ActivityLoginBinding
import com.cyrzan.starwars.di.module.ActivityModule
import com.cyrzan.starwars.ui.base.BaseActivity

class LoginActivity : BaseActivity(), LoginContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel: LoginViewModel

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
