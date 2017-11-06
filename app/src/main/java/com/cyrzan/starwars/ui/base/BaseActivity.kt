package com.cyrzan.starwars.ui.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by Patryk on 06.11.2017.
 */

abstract class BaseActivity : AppCompatActivity() {

    // Inject Dagger
    abstract fun inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        super.onCreate(savedInstanceState)
    }
}