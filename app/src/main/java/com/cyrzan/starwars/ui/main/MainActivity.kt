package com.cyrzan.starwars.ui.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.cyrzan.starwars.R
import com.cyrzan.starwars.ui.base.BaseActivity

class MainActivity : BaseActivity(), MainContract.View  {
    override fun inject() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
